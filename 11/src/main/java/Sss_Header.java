import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sss_header")
public class Sss_Header extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int x = Integer.parseInt(req.getHeader("Value-x"));
        int y = Integer.parseInt(req.getHeader("Value-y"));
        int z = x + y;
        resp.addIntHeader("Value-z", z);


    }
}