import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputLine;
        PrintWriter pw = response.getWriter();
        URL obj = new URL("http://localhost:8080/Bbb");
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("ErsHeader1", "ERS header 1 value");
        httpURLConnection.setRequestProperty("ErsHeader2", "ERS header 2 value");
        httpURLConnection.setRequestProperty("ErsHeader3", "ERS header 3 value");
        String urlParameters = "queryParam1=queryParam1value&queryParam2=queryParam2value&queryParam3=queryParam3value";

        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        pw.println("Response Code: " + httpURLConnection.getResponseCode());
        pw.println();
        pw.println("Response:");

        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        while ((inputLine = in.readLine()) != null) pw.println(inputLine);

        Map<String, List<String>> headerNames = httpURLConnection.getHeaderFields();

        pw.println();
        pw.println("Response Headers (Servlet Aaa):");

        for (Map.Entry<String, List<String>> header : headerNames.entrySet()) {
            pw.println(header.getKey() + ": " + header.getValue());
        }

        in.close();
    }
}
