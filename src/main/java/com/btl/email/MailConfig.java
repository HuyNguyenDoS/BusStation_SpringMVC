/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.email;


/**
 *
 * @author HUY NGUYEN
 */
public class MailConfig {

    public static final String HOST_NAME = "mail.smtp.host";
 
    public static final int SSL_PORT = 465; // Port for SSL
 
    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS
 
    public static final String APP_EMAIL = "huynguyenvo2001@gmail.com"; // your email
 
    public static final String APP_PASSWORD = "gxgsqmhhdsgwcekb"; // your password
 
    public static final String RECEIVE_EMAIL = "1951052138nguyen@ou.edu.vn"; 
}
//        try {
//            // Recipient's email ID needs to be mentioned.
//            String to = "1951052138nguyen@ou.edu.vn";
//
//            // Sender's email ID needs to be mentioned
//            String from = "huynguyenvo2001@gmail.com";
//
//            // Assuming you are sending email from through gmails smtp
//            String host = "smtp.gmail.com";
//
//            // Get system properties
//            Properties properties = System.getProperties();
//
//            // Setup mail server
//            properties.put("mail.smtp.host", host);
//            properties.put("mail.smtp.port", "465");
//            properties.put("mail.smtp.ssl.enable", "true");
//            properties.put("mail.smtp.auth", "true");
//
//            // Get the Session object.// and pass 
//            org.hibernate.Session session = org.hibernate.Session.getInstance(properties, new javax.mail.Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication("huynguyenvo2001@gmail.com", "gxgsqmhhdsgwcekb");
//                }
//            });
//
//            //session.setDebug(true);
//            try {
//                // Create a default MimeMessage object.
//                MimeMessage message = new MimeMessage(session);
//
//                // Set From: header field of the header.
//                message.setFrom(new InternetAddress(from));
//
//                // Set To: header field of the header.
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//                // Set Subject: header field
//                message.setSubject("This is confirm mail from Transport!");
//
//                message.setText("Simple message body");
//                System.out.println("sending...");
//                // Send message
//                Transport.send(message);
//                System.out.println("Sent message successfully....");
//            } catch (MessagingException mex) {
//                mex.printStackTrace();
//            }
//        } catch (Exception e) {
//            System.err.println(e);
//        }