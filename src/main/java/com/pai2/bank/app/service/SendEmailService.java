package com.pai2.bank.app.service;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Transport;

@Stateless(name = "SendEmailService", mappedName = "SendEmailService")
public class SendEmailService {


    public boolean sendEmail(String receipient, String emailMessage, String subject){

        String from = "bankapp@prokonto.pl";
        final String username = "bankapp";
        final String password = "bankAppPAI2";

        String host = "poczta.o2.pl";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receipient));

            message.setSubject(subject);

            message.setText(emailMessage);

            Transport.send(message);

            System.out.println("Sent message successfully....");
            return true;

        } catch (MessagingException e) {
            return false;

        }

    }


    public String createEmailWithCode(String code){

        return "Witaj, \n zarejestrowaliśmy Twoją prośbę o przelew. Aby wykonać przelew musisz potwierdzić go kodem.\n" +
                "Twój kod to: "+code+", wpisz go w odpowiednim miejscu w aplikacji i zatwierdź przelew.";
    }



}
