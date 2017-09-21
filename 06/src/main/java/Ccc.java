import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {

    private String atrCBean;
    private String CBean;

    public Ccc() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("goGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCBean(req.getParameter("radio"));

        if (getCBean().equals("new")) {
            CBean cBean = new CBean();

            if (!req.getParameter("value1").equals("") && !req.getParameter("value2").equals("") && !req.getParameter("value3").equals("")) {
                cBean.setValue1(req.getParameter("value1"));
                cBean.setValue2(req.getParameter("value2"));
                cBean.setValue3(req.getParameter("value3"));
            }
        } else if (getCBean().equals("old")) {
            System.out.println("radio:old");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    /*------------------------------------------------------------*/

    public String getAtrCBean() {
        return atrCBean;
    }

    public void setAtrCBean(String atrCBean) {
        this.atrCBean = atrCBean;
    }

    public String getCBean() {
        return CBean;
    }

    public void setCBean(String CBean) {
        this.CBean = CBean;
    }
}
