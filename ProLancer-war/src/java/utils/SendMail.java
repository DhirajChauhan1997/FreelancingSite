/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author yogi_gmt
 */
public class SendMail {
   
    
    public void sendmailToUser(String userEmail){
     final String username="yogeshgamit178@outlook.com";
         final String password="@yogi_gmT9644";
        
         
            
         Properties properties=new Properties();
         properties.put("mail.smtp.auth","true");
         properties.put("mail.smtp.starttls.enable","true");
         properties.put("mail.smtp.host", "outlook.office365.com");
         properties.put("mail.smtp.port", "587");
         
         Session session=Session.getInstance(properties,
                 new javax.mail.Authenticator() {
                     protected  PasswordAuthentication getPasswordAuthentication(){
                         return new PasswordAuthentication(username, password);
                     }
                 });
         try {
             Message message=new MimeMessage(session);
             message.setFrom(new InternetAddress("yogeshgamit178@outlook.com"));
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yogeshgamit178@gmail.com"));
             message.setSubject("Test1");
             message.setText("hi dhiraj bro");
             
             Transport.send(message);
             System.out.println("Done");
             
          } catch (Exception e) {
              throw new RuntimeException(e);
        }   
    }
       
}
