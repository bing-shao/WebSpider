package com.swu.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.swu.dao.impl.SpiderImagesDAOimpl;
import com.swu.dto.SpiderImages;
import com.swu.dto.Stat;
import com.swu.util.TimeUtil;
import com.swu.util.UNIDGenerate;
/**
 * 
 * 
 * @Title: SpiderImagesService
 * @package: com.swu.service
 * @Description: TODO
 * @author ljuenan@linewell
 * @date 2016-3-17 下午9:49:58
 * @version V1.0
 */
public class SpiderImagesService {
	ArrayList<String> allurlSet = new ArrayList<String>();// 所有的网页url，需要更高效的去重可以考虑HashSet
	ArrayList<String> notCrawlurlSet = new ArrayList<String>();// 未爬过的网页url
	Map<String, Integer> depth = new HashMap<String, Integer>();// 所有网页的url深度

	int count = 0; // 表示有多少个线程处于wait状态
	public static final Object signal = new Object(); // 线程间通信变量

	/**
	 * 
	 * 功能：开始爬行
	 * 
	 * @author 姓名 ljuenan@linewell.com
	 * @since 2016-3-8 下午9:25:42
	 * @param
	 * @return
	 * 
	 */
	public void spider(final String userUnid, final int crawDepth, final int threadCount) {

		// 获取当前时间戳
		final long start = System.currentTimeMillis();

		// 循环，如果i小于线程数目，就继续执行
		for (int i = 0; i < threadCount; i++) {
			// 实例化一个多线程，重写runnable方法
			new Thread(new Runnable() {
				@SuppressWarnings({ "deprecation", "rawtypes" })
				public void run() {
					while (true) {
						// 从list中获取不为空的网址
						String tmp = getAUrl();

						if (tmp != null) {
							try {
								crawler(tmp, userUnid, crawDepth);
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						} else {
							synchronized (signal) {
								try {
									count++;
									if ((notCrawlurlSet.size() == 0 && Thread.activeCount() == 1)
											|| count == threadCount) {
										long end = System.currentTimeMillis();
										
										SpiderImagesDAOimpl daoimpl = new SpiderImagesDAOimpl();
										//收集要添加到统计记录表的数据
                                    	String num=String.valueOf(allurlSet.size());
                                    	String time = Long.toString((end-start)/1000);
                                    	Stat statUrl = new Stat();
                                    	statUrl.setSTATURL_CREATTIME(TimeUtil.getNowTime());
                                    	statUrl.setSTATURL_TOTALNUM(num);
                                    	statUrl.setSTATURL_TOTALTIME(time);
                                    	statUrl.setSTATURL_UNID(new UNIDGenerate().getUnid());
                                    	statUrl.setSTATURL_USER(userUnid);
                                    	//收集要修改临时网页表的数据(结束标志)
                                    	String state = "end";
                                    	//添加数据到统计记录表
                                    	daoimpl.addStatUrl(statUrl);
                                    	//修改临时数据表数据
                                    	daoimpl.update(state,userUnid);
										// 获取当前的所有线程，并将其放入迭代器
										Iterator iter = Thread.getAllStackTraces().keySet().iterator();
										// 循环直到迭代器中没有数值为止
										while (iter.hasNext()) {
											// 获取当前的数据
											Thread t = (Thread) iter.next();
											// 如果得到的线程匹配正在执行的线程，就跳过该线程
											if (t == Thread.currentThread()) {
												continue;
											}
											// 如果得到的线程以thread开头，则stop该线程
											if (t.getName().startsWith("thread")) {
												t.stop();
											}
										}
										// stop当前线程
										Thread.currentThread().stop();
									}

									else {
										signal.wait();
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}

					}

				}

			}, "thread-" + i).start();
		}
	}

	// synchronized用于保证当前模块在同一时间只能由一个线程占用
	public synchronized String getAUrl() {
		// 判断为爬过的网址是否为空，如果是空，返回空，如果不为空，则删除该网站，并返回该网址
		if (notCrawlurlSet.isEmpty())
			return null;
		String tmpAUrl;
		tmpAUrl = notCrawlurlSet.get(0);
		notCrawlurlSet.remove(0);
		return tmpAUrl;
	}

	public synchronized void addUrl(String url, int d) {
		// 未爬过的网页
		notCrawlurlSet.add(url);
		// 所有的网页
		allurlSet.add(url);
		// 网页的深度
		depth.put(url, d);
	}

	// 爬网页sUrl
	public void crawler(String sUrl, String userUnid, int crawDepth) throws UnsupportedEncodingException {
		URL url;
		try {
			// 将当前的url赋予
			url = new URL(sUrl);
			InputStream is = url.openStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(is, "GBK"));
			StringBuffer sb = new StringBuffer();// sb为爬到的网页内容
			String rLine = null;
			while ((rLine = bReader.readLine()) != null) {
				sb.append(rLine);
				sb.append("/r/n");
			}
			int d = depth.get(sUrl);
			parseContextImages(sb.toString(), d + 1,userUnid,sUrl);
			// downLoadFile.downloadFile(sUrl);
			if (d < crawDepth) {
				// 解析网页内容，从中提取链接
				parseContextURL(sb.toString(), d + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(sUrl);

		}
	}

	public void parseContextImages(String context,int d,String userUnid,String sUrl) {
		String regex = "<img.*src=(.*?)[^>]*?>|image:url(.*?)[)]|img(.*?)[)]";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(context);
		while (mt.find()) {
			Matcher myurl = Pattern.compile("(http|https){1}:\"?(.*?)[\"|)|\']").matcher(mt.group());
			while (myurl.find()) {
				String str = myurl.group().replaceAll("\\\\|\"|>|;", "");
				SpiderImages spiderImage = new SpiderImages();
				spiderImage.setIMAGES_UNID(new UNIDGenerate().getUnid());
				spiderImage.setIMAGES_CRAWL(TimeUtil.getNowTime());
				spiderImage.setIMAGES_DEPTH(String.valueOf(d));
				spiderImage.setIMAGES_SOURCE(sUrl);
				spiderImage.setIMAGES_USER(userUnid);
				spiderImage.setIMAGES_THREAD(Thread.currentThread().getName());
				SpiderImagesDAOimpl dao = new SpiderImagesDAOimpl();
				if (str.endsWith(")")) {
					int endindex=str.lastIndexOf(")");
					String str1 = str.substring(0, endindex);
					if (str1.endsWith("jpg") || str1.endsWith("png") || str1.endsWith("gif")) {
						spiderImage.setIMAGES_URL(str1);
						spiderImage.setIMAGES_TYPE(str1.substring(str1.length()-4));
						dao.add(spiderImage);
					}
				}else{
					if (str.endsWith("jpg") || str.endsWith("png") || str.endsWith("gif")) {
						spiderImage.setIMAGES_URL(str);
						spiderImage.setIMAGES_TYPE(str.substring(str.length()-4));
						dao.add(spiderImage);
					}
				}
			}
		}
	}

	// 从context提取url地址
	public void parseContextURL(String context, int dep) {
		String regex = "<a href.*?/a>";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(context);
		while (mt.find()) {
			Matcher myurl = Pattern.compile("href=\".*?\"").matcher(mt.group());

			while (myurl.find()) {
				String str = myurl.group().replaceAll("href=\"|\"", "");
				if (str.contains("http:")) { // 取出一些不是url的地址
					if (!allurlSet.contains(str)) {
						addUrl(str, dep);// 加入一个新的url
						if (count > 0) { // 如果有等待的线程，则唤醒
							synchronized (signal) {
								count--;
								signal.notify();
							}
						}

					}
				}
			}
		}
	}
}