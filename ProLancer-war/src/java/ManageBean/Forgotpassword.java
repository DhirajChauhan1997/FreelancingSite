/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import EJB.AdminSessionBeanLocal;
import Entity.User;
import java.util.Properties;
import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author yogi_gmt
 */
@Named(value = "forgotpassword")
@RequestScoped
public class Forgotpassword {

    @EJB
    AdminSessionBeanLocal asbl;

    String email;

    public Forgotpassword() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sendMail() {

        final String username = "yogeshgamit178@outlook.com";
        final String password = "@yogi_gmT9644";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("yogeshgamit178@outlook.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Fogot password Recovery");
            //get Data Of User By Enail
            User u = new User();
            u = asbl.getUserbyEmail(email);

            message.setText("<h3>Your Username is '" + u.getEmail() + "'</h3><br></br><h3>Your Password is '" + u.getPassword() + "'</h3><br></br>");

            Transport.send(message);
            System.out.println("Successfuly send Username And Password");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
