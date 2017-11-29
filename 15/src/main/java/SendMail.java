import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(urlPatterns = "/send")
public class SendMail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendSMTP(req, resp);
    }

    private void sendSMTP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String host = "smtp.gmail.com";
        final String port = "587";

        final String from = "java.lab.test.mail@gmail.com";
        final String password = "123456qwe";
        String to = req.getParameter("sendto");

        String subject = req.getParameter("subject");
        String mailBody = req.getParameter("body");

/*        String subject = "Hello Dariya Igorevna";
        String mailBody = "This is mail body";*/

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        PrintWriter printWriter = resp.getWriter();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(mailBody);
            Transport.send(message);
            printWriter.println("Sent message to [" + to + "] successfully.");
            System.out.println("Sent message to [" + to + "] successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
