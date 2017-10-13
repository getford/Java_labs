import pack.CBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {
    private String atrCBean;
    private String radioCBean;

    public Ccc() {
    }

    @Override
    public void init() throws ServletException {
        super.init();

        CBean cBean = new CBean();

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("atrCBean", cBean);

        cBean.setAtrCBean(String.valueOf(servletContext.getAttribute("atrCBean")));
        System.out.println(servletContext.getAttribute("atrCBean"));
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
        setRadioCBean(req.getParameter("radio"));
        if (getRadioCBean().equals("new")) {
            CBean cBean = new CBean();

            if (!req.getParameter("value1").equals("") && !req.getParameter("value2").equals("") && !req.getParameter("value3").equals("")) {
                cBean.setValue1(req.getParameter("value1"));
                cBean.setValue2(req.getParameter("value2"));
                cBean.setValue3(req.getParameter("value3"));
                ServletContext servletContext = getServletContext();
                servletContext.setAttribute("atrCBean", cBean);

                cBean.setAtrCBean(String.valueOf(servletContext.getAttribute("atrCBean")));
                System.out.println(servletContext.getAttribute("atrCBean"));

                PrintWriter printWriter = resp.getWriter();
                printWriter.println(
                        "<br>Value1: " + cBean.getValue1() +
                                "<br>Value2: " + cBean.getValue2() +
                                "<br>Value3: " + cBean.getValue3() +
                                "<hr>Attribute: " + servletContext.getAttribute("atrCBean")
                );
            }
        } else if (getRadioCBean().equals("old")) {
            ServletContext servletContext = getServletContext();
            System.out.println(servletContext.getAttribute("atrCBean"));
            System.out.println("radio:old");

            resp.sendRedirect("/Ccc.jsp");
        }
        if (getRadioCBean().equals(""))
            System.out.println("not checked");
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

    public String getRadioCBean() {
        return radioCBean;
    }

    public void setRadioCBean(String CBean) {
        this.radioCBean = CBean;
    }
}
