package com.swu.util;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class SendEmail2{
   public static boolean  sendEmail2(String email,String randomPwd){
	  //设置标记
	  boolean result = false;
      // 收件人电子邮箱
      String to = email;

      // 发件人电子邮箱
      String from = "18883247510@163.com";

      // 指定发送邮件的主机为 localhost
      String host = "smtp.163.com";  //163 邮件服务器

      // 获取系统属性
      Properties properties = System.getProperties();

      // 设置邮件服务器
      properties.setProperty("mail.smtp.host", host);

      properties.put("mail.smtp.auth", "true");
      // 获取默认session对象
      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	    public PasswordAuthentication getPasswordAuthentication()
	    {
	     return new PasswordAuthentication("18883247510@163.com", "LONG89562566"); //发件人邮件用户名、密码
	    }
	   });

      try{
         // 创建默认的 MimeMessage 对象
         MimeMessage message = new MimeMessage(session);

         // Set From: 头部头字段
         message.setFrom(new InternetAddress(from));

         // Set To: 头部头字段
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: 头部头字段
         message.setSubject("您好，网络机器人祝您成功找回密码!");

         // 创建消息部分
         BodyPart messageBodyPart = new MimeBodyPart();
 
        
         // 创建多重消息
         Multipart multipart = new MimeMultipart();
 
         // 设置html文本消息部分
         messageBodyPart.setContent("<h1>"+randomPwd+"</h1>",
                 "text/html");
         multipart.addBodyPart(messageBodyPart);
         
         // 附件部分
//         messageBodyPart = new MimeBodyPart();
//         String filename = "file.txt";
//         DataSource source = new FileDataSource(filename);
//         messageBodyPart.setDataHandler(new DataHandler(source));
//         messageBodyPart.setFileName(filename);
//         multipart.addBodyPart(messageBodyPart);
// 
         // 发送完整消息
         message.setContent(multipart );
         // 发送消息
         Transport.send(message);
         result = true;
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
      return result;
   }
}