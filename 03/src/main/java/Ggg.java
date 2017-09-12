import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Ggg", urlPatterns = "/Ggg")
public class Ggg extends HttpServlet {

    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Ggg:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Ggg:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Ggg:service");

        PrintWriter printWriter = resp.getWriter();

        String _click = req.getParameter("click");

        if (_click.equalsIgnoreCase("value4")) {
            resp.sendRedirect("/redirect.html");
        }

        if (_click.equalsIgnoreCase("value5")) {
            String param5 = req.getParameter("param5");

            printWriter.println("<br/><h4>Parameter: " + param5 + "</h4>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Ggg:doGet");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Servlet Ggg");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);
        System.out.println("Ggg:doPost");
    }
}
