import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Sss")
public class Sss extends HttpServlet {

    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Sss:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Sss:service");
        System.out.println("Method: " + req.getMethod());
        System.out.println("Port: " + req.getServerPort());

        PrintWriter pw = resp.getWriter();
        pw.println("<b><br/>Method:</b> " + req.getMethod());
        pw.println("<b><br/>Host:</b> " + req.getRemoteHost());
        pw.println("<b><br/>IP:</b> " + req.getRemoteAddr());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();

        String firstName = req.getParameter("fn");
        String lastName = req.getParameter("ln");

        pw.println(firstName + "\t" + lastName);
        pw.println("<b><br/>Строка GET-запроса:</b> " + req.getQueryString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.setContentType("text/html;charset=utf-8");

        String firstName = req.getParameter("fn");
        String lastName = req.getParameter("ln");

        PrintWriter pw = resp.getWriter();
        pw.println(firstName + "\t" + lastName);
    }
}
