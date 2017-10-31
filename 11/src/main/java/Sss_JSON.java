import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sss_json")
public class Sss_JSON extends HttpServlet {
    static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getHeader("XRand-N"));
        System.out.println(n);
        resp.setContentType("text/json");
        PrintWriter w = resp.getWriter();
        StringBuilder s = new StringBuilder("{\"X\":[");
        for (int i = 0; i < 10; i++) {
            s.append("{\"randValue\":").append((int) (Math.random() * (n - (n * -1))) + n).append("}").append((i < 9) ? "," : " ");
        }
        s.append("]}");
        System.out.println(s);
        
        w.println(s);


//
//        PrintWriter w = resp.getWriter();
//        StringBuilder s =
//                new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>");
//        for (int i = 0; i < 10; i++) {
//            s.append("<num>").append((int) (Math.random() * (n - (n * -1))) + n).append("</num>");
//        }
//        s.append("</rand>");
//        w.println(s);

    }
}
