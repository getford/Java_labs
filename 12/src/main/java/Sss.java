import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/sss")
public class Sss extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Sss:Servlet");
    }
}
