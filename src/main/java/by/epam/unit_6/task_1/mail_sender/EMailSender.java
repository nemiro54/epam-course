package by.epam.unit_6.task_1.mail_sender;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class EMailSender {
    private String to;
    private String from;
    private String host = "localhost";
    private Address[] addresses;
    private String[] arrayAddresses;
    private List<String> listAddresses;

    public EMailSender(String to, String from) {
        this.to = to;
        this.from = from;
    }

    public EMailSender(Address[] addresses, String from) {
        this.addresses = addresses;
        this.from = from;
    }

    public EMailSender(String[] arrayAddresses, String from) {
        this.arrayAddresses = arrayAddresses;
        this.from = from;
        setAddresses(arrayAddresses);
    }

    public EMailSender(List<String> listAddresses, String from) {
        this.listAddresses = listAddresses;
        this.from = from;
        setAddresses(listAddresses);
    }

    public void sendEMail(String subject, String text) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEMails(String subject, String text) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void setAddresses(String[] arrayAddresses) {
        addresses = new Address[arrayAddresses.length];

        for (int i = 0; i < arrayAddresses.length; i++) {
            try {
                addresses[i] = new InternetAddress(arrayAddresses[i]);
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }
    }

    private void setAddresses(List<String> listAddresses) {
        addresses = new Address[listAddresses.size()];

        for (int i = 0; i < listAddresses.size(); i++) {
            try {
                addresses[i] = new InternetAddress(listAddresses.get(i));
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public String[] getArrayAddresses() {
        return arrayAddresses;
    }

    public void setArrayAddresses(String[] arrayAddresses) {
        this.arrayAddresses = arrayAddresses;
    }

    public List<String> getListAddresses() {
        return listAddresses;
    }

    public void setListAddresses(List<String> listAddresses) {
        this.listAddresses = listAddresses;
    }

    @Override
    public String toString() {
        return "EMailSender{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", host='" + host + '\'' +
                ", addresses=" + Arrays.toString(addresses) +
                '}';
    }
}
