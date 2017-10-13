import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/URLn")
public class URLn extends HttpServlet {
    @Override
    public void destroy() {
        //super.destroy();
        System.out.println("destroy");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("urln");

        PrintWriter printWriter = resp.getWriter();

        if (param.equals("")) {
            printWriter.println("parameter URLn not found");
        } else {
            if (param.equals("1")) {
                resp.sendRedirect(getServletContext().getInitParameter("URL1"));
            }
            if (param.equals("2")) {
                resp.sendRedirect(getServletContext().getInitParameter("URL2"));
            }
        }
    }
}
