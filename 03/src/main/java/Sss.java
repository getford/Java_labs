import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
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
        System.out.println("Sss:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Sss:service");

        String _click = req.getParameter("click");

        PrintWriter printWriter = resp.getWriter();


        if(_click == null){     // По гиперссылке
            printWriter.println("Sss:doGet");
        }

        if (_click.equalsIgnoreCase("value")) { // переадресация на Ggg
            resp.sendRedirect("/Ggg");
        }

        if (_click.equalsIgnoreCase("value1")) {    // POST запрос с Sss
            printWriter.println("Sss:POST in service");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Sss:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Sss:doPost");


    }
}