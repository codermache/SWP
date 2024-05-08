/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

//import jakarta.mail.Authenticator;
//import jakarta.mail.Message;
//import jakarta.mail.MessagingException;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author admin
 */
public class SendEmail {

//    public String getRandom() {
//        Random rnd = new Random();
//        int number = rnd.nextInt(999999);
//        return String.format("%06d", number);
//    }
//send email to the user email
    public static void sendEmail(String toAddress, String subject, String content) {
//        boolean test = false;
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        String host = "smtp.gmail.com";
        String fromEmail = "mnguyenan94@gmail.com";
        String password = "Thinhmache123@#";

        try {

            // your host email smtp server details
            Properties properties = System.getProperties();
//            properties.put("mail.smtp.host", host);
//            properties.put("mail.smtp.user", fromEmail);
//            properties.put("mail.smtp.password", password);
            properties.put("mail.smtp.auth", "true");      
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587"); // 587 is the port number of yahoo mail
//            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(content);

//            //set email message details
//            Message mess = new MimeMessage(session);
//
//            //set from email address
//            mess.setFrom(new InternetAddress(fromEmail));
//            //set to email address or destination email address
//            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//
//            //set email subject
//            mess.setSubject("User Email Verification");
//
//            //set message text
//            mess.setText("Registered successfully.Please verify your account using this code: " + user.getCode());
//            //send the message
//            Transport.send(mess);
//
//            test = true;
            Transport.send(msg);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
//    
//      public static void main(String[] args) {
//        String recipient = "mnguyenan94@gmail.com";
//        String subject = "Test Email";
//        String message = "This is a test email.";
//
//        sendEmail(recipient, subject, message);
//    }
}
