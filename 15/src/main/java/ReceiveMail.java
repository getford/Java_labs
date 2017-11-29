import com.sun.mail.pop3.POP3Store;

import javax.mail.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(urlPatterns = "/receive")
public class ReceiveMail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            showMail(req, resp);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void showMail(HttpServletRequest req, HttpServletResponse resp) throws MessagingException, IOException {
        final String username = "java.lab.test.mail";
        final String password = "123456qwe";

        final String protocol = "pop3";
        final String port = "995";
        final String host = "pop.gmail.com";

        try {
            Properties properties = new Properties();
            properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.pop3.socketFactory.fallback", "false");
            properties.put("mail.pop3.socketFactory.port", port);
            properties.put("mail.pop3.port", port);
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.user", username);
            properties.put("mail.store.protocol", protocol);

            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            Session session = Session.getDefaultInstance(properties, auth);
            Store store = null;
            store = session.getStore(protocol);
            store.connect(host, username, password);

            Folder inbox = null;
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            try {
                for (Message message : messages) {
                    System.out.println("Mail " + message.getMessageNumber() + " was receive success.");
                    PrintWriter out = resp.getWriter();
                    out.println(
                            "<html>" +
                                    "<body>" +
                                    "Message Number: " + "<b>" + message.getMessageNumber() + "</b>" + "<br>" +
                                    "Send date: " + "<b>" + message.getSentDate() + "</b>" + "<br>" +
                                    "Message Subject: " + "<b>" + message.getSubject() + "</b>" + "<br>" +
                                    "Message: " + "<b>" + message.getContent() + "</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "</body>" +
                                    "</html>"
                    );

                }
                inbox.close(false);
                store.close();

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
