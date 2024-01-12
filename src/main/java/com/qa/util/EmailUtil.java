package com.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {


    public static void sendEmail(String scenario, String screenshotName, byte[] img ) {
        // Sender's email address
        String senderEmail = "sumag.git@gmail.com";
        // Sender's Gmail App Password (generated in your Google Account settings)
        String appPassword = "ifar ohba yggt pcnr";//"Savvy@123";

        // Recipient's email address
        String recipientEmail = "jira@suma-g.atlassian.net";

        // Set up mail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with an Authenticator
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(senderEmail, appPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the email subject and content
            message.setSubject("Failed Scenario:"+scenario);
            message.setText("Scenario "+scenario+" is failed. Please find the attached Screenshot : "+screenshotName);

            if(img !=null) {
            	
            	File file =  new File("C:\\Temp\\ALGO\\"+screenshotName+System.currentTimeMillis()+".png");
            	//File file =  Files.createFile("C:\\Temp\\ALGO\\"+screenshotName+System.currentTimeMillis(),);
            	// using OutputStream
                try {
					OutputStream os = new FileOutputStream(file,true);
    				// Starting writing the bytes in it
					os.write(img);
					os.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                // Create a multipart message
	            Multipart multipart = new MimeMultipart();
	            
	            MimeBodyPart messageBodyPart = new MimeBodyPart();

	            messageBodyPart.setText("Scenario "+scenario+" is failed. Please find the attached Screenshot : "+screenshotName);
	            // Set text message part
	            multipart.addBodyPart(messageBodyPart);
	            
	            // Part two is attachment
	            messageBodyPart = new MimeBodyPart();
	            //String filename = "/home/manisha/file.txt";
	            DataSource source = new FileDataSource(file);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(file.getName());
	            multipart.addBodyPart(messageBodyPart);
	
	            // Send the complete message parts
	            message.setContent(multipart);
            
            }// if image 
            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully from Java mail with attachment!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}
