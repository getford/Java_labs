import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        PrintWriter printWriter = resp.getWriter();

        HttpClient httpClient = new HttpClient();*/
        String uri = "http://" + req.getServerName() + ":" + req.getServerPort() + "/Bbb";

        req.setAttribute("value1", "value1");
        req.setAttribute("value2", "value2");
        req.setAttribute("value3", "value3");

       /* printWriter.println(
                "Param1: " + req.getParameter("value1") +
                "<br/>Param2: " + req.getParameter("value2") +
                        "<br/>Param3: " + req.getParameter("value3"));

        GetMethod getMethod = new GetMethod();
        getMethod.addRequestHeader("Header1", "header1");
        getMethod.addRequestHeader("Header2", "header2");
        getMethod.addRequestHeader("Header3", "header3");

        httpClient.executeMethod(getMethod);
*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(uri);
        requestDispatcher.forward(req, resp);
    }
}
