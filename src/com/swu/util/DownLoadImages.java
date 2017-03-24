package com.swu.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoadImages {  
	   public static String downloadImages(String sUrl) {  
	        URL url = null;
	        String savePath = "F:\\images\\";
	            try {  
	                url = new URL(sUrl);  
	                DataInputStream dataInputStream = new DataInputStream(url.openStream());  
	                String imageName = (new UNIDGenerate().getUnid())+sUrl.substring(sUrl.length()-4); 
	                //先创建最底级的文件夹
	    			File file = new File(savePath);
	    			// 如果指定的路径位置文件夹不存在，那么创建指定目录
	    			if (!file.exists()) {
	    				file.mkdirs();
	    			}
	                FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath + imageName));  
	  
	                byte[] buffer = new byte[1024];  
	                int length;  
	  
	                while ((length = dataInputStream.read(buffer)) > 0) {  
	                    fileOutputStream.write(buffer, 0, length);  
	                }  
	  
	                dataInputStream.close();  
	                fileOutputStream.close();  
	            } catch (MalformedURLException e) {  
	                e.printStackTrace();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }
				return savePath;  
	        } 
}     