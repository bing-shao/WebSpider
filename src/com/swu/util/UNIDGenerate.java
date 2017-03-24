package com.swu.util;


import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * unid生成器对象.w使用了hibernate的算法 <p/>使用方法示例：
 *
 * <pre>
 * public static void main(String[] args)
 * {
 * 	UNIDGenerate unid = new UNIDGenerate();
 * 	System.out.println(&quot;unid=&quot; + unid);
 * }
 * </pre>
 *
 * @author http://www.linewell.com
 * @version 1.0
 */
public class UNIDGenerate {

	private static final int IP;
	
	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	private static short counter = (short) 0;

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private String sep = "";

	/**
	 * 从java 的虚拟机计算出一个值 Unique across JVMs on this machine (unless they load
	 * this class in the same quater second - very unlikely)
	 */
	protected int getJVM() {
		return JVM;
	}

	/**
	 * 在一个毫秒单位里的唯一整数值 Unique in a millisecond for this JVM instance (unless
	 * there are > Short.MAX_VALUE instances created in a millisecond)
	 */
	protected short getCount() {
		synchronized (UNIDGenerate.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	 * 局域网唯一IP地址 Unique in a local network
	 */
	protected int getIP() {
		return IP;
	}

	/**
	 * Unique down to millisecond
	 */
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	/**
	 * 返回生成的unid
	 *
	 * @return String-unid值
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer(36).append(format(getIP())).append(
				sep).append(format(getJVM())).append(sep).append(
				format(getHiTime())).append(sep).append(format(getLoTime()))
				.append(sep).append(format(getCount()));
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return sb.toString().toUpperCase();
		}
		md5.update(sb.toString().getBytes());
		byte[] array = md5.digest();
		StringBuffer ret = new StringBuffer();
		for (int j = 0; j < array.length; ++j) {
			int b = array[j] & 0xFF;
			if (b < 0x10)
				ret.append('0');
			ret.append(Integer.toHexString(b));
		}
		return ret.toString().toUpperCase();
	}

	/**
	 * 返回生成的unid
	 *
	 * @return String-unid值
	 */
	public String getUnid() {
		return toString();
	}

	/**
	 * 判断输入的字符串是否为32位Unid
	 *
	 * @param str
	 *            输入字符串
	 * @return 若是32位Unid，则返回True,否则返回False
	 */
	public static boolean isUnid(String str) {
		if (str.length() == 32 && str.matches("[A-Z0-9]{32}")) {
			return true;
		}
		return false;
	}

	public static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

}