import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Jjj extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Jjj:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("Jjj:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("Jjj:doPost");
    }
}
