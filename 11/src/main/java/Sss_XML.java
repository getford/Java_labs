import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sss_xml")
public class Sss_XML extends HttpServlet {
    static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getHeader("XRand-N"));
        System.out.println(n);
        resp.setContentType("text/xml");
        PrintWriter w = resp.getWriter();
        StringBuilder s =
                new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>");
        for (int i = 0; i < 10; i++) {
            s.append("<num>").append((int) (Math.random() * (n - (n * -1))) + n).append("</num>");
        }
        s.append("</rand>");
        w.println(s);

    }
}
