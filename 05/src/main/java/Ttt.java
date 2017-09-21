import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Ttt")
public class Ttt extends HttpServlet {

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String firstname = httpServletRequest.getParameter("firstname");
        String lastname = httpServletRequest.getParameter("lastname");
        String sex = httpServletRequest.getParameter("sex");

        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println(
                "<br/>Firstname: " + firstname +
                        "<br/>Lastname: " + lastname +
                        "<br/>Sex: " + sex
        );
        // printWriter.close();
    }

    public Ttt() {
        super();
        System.out.println("Constructor");
    }
}
