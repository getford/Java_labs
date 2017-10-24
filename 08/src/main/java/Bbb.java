import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/Bbb")
public class Bbb extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> headerNames = request.getHeaderNames();
        PrintWriter pw = response.getWriter();
        pw.println("Headers from Servlet Bbb: ");

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            pw.println(key + ": " + value);
        }

        pw.println();
        pw.println("Query params from ServletB:");
        pw.println("queryParam1: " + request.getParameter("queryParam1"));
        pw.println("queryParam2: " + request.getParameter("queryParam2"));
        pw.println("queryParam3: " + request.getParameter("queryParam3"));

        response.setHeader("SERVLET Aaa", "sample value");
        response.setHeader("SERVLET Bbb", "sample value");
    }
}
