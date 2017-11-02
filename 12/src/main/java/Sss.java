import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet(urlPatterns = "/sss")
public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Sss:Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method sss servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method sss servlet");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        String login = null;
        Principal usernamePrincipal = req.getUserPrincipal();
        if (usernamePrincipal != null)
            login = usernamePrincipal.getName();

        printWriter.println(login);
    }
}
