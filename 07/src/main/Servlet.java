package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        String _url1 = getServletContext().getInitParameter("URL1");
        String _url2 = getServletContext().getInitParameter("URL2");

        if(_url2 != null || _url1 != null) {
            PrintWriter out = response.getWriter();
            if(_url1 != null) {
                out.print("URL1: "+_url1+"\n");
            }
            if(_url2 != null) {
                out.print("URL2: "+_url2+"\n");
            }
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("Message from /Servlet !!!"+"\n");
            out.print("parameter URLn not found");
        }

       /* System.out.println(_url1);
        System.out.println(_url2);

        Enumeration en = sc.getInitParameterNames();
        String x;
        while (en.hasMoreElements()) {
            x = (String) en.nextElement();
            System.out.println("x="+x);
            System.out.println(sc.getInitParameter(x));
        }*/
    }
}
