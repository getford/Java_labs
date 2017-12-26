package main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;	
import java.io.PrintWriter;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.parser.Parser;
import main.СBean;

@WebServlet(name = "Ccc")
public class Ccc extends HttpServlet {

    public void init() throws ServletException {
        super.init();
        ServletContext sc = getServletContext();
        СBean cb = new СBean();
        sc.setAttribute("atr_CB",cb);
    }
    public void service(HttpServletRequest rq,  HttpServletResponse rs)  throws ServletException, IOException {
        super.service(rq,rs);
        ServletContext sc = getServletContext();
        СBean cb = new СBean("new");

        String _CB = sc.getAttribute("atr_CB").toString();
        String _Value1 = rq.getParameter("Value1");
        String _Value2 = rq.getParameter("Value2");
        String _Value3 = rq.getParameter("Value3");

        String[] _CB_Val = _CB.split(";");
        String _CB0 = _CB_Val[0];
        String _CB1 = _CB_Val[1];
        String _CB2 = _CB_Val[2];
        String _CB3 = _CB_Val[3];

        if(_CB0.equalsIgnoreCase(("null"))){
            cb.setValue1(_Value1);
            cb.setValue2(_Value2);
            cb.setValue3(_Value3);
            sc.setAttribute("atr_CB",cb);
        }
        else if(_CB0.equalsIgnoreCase("new")){
            if(_Value1.equalsIgnoreCase(_CB1)
                    &&_Value2.equalsIgnoreCase(_CB2)
                    &&_Value3.equalsIgnoreCase(_CB3)){
                cb.setValue("old");
                cb.setValue1(_Value1);
                cb.setValue2(_Value2);
                cb.setValue3(_Value3);
                sc.setAttribute("atr_CB",cb);
            }
            else {
                cb.setValue1(_Value1);
                cb.setValue2(_Value2);
                cb.setValue3(_Value3);
                sc.setAttribute("atr_CB", cb);
            }
        }
        else if(_CB0.equalsIgnoreCase("old")){
            if(_Value1.equalsIgnoreCase(_CB1)
                    &&_Value2.equalsIgnoreCase(_CB2)
                    &&_Value3.equalsIgnoreCase(_CB3)){
                cb.setValue("old");
                cb.setValue1(_Value1);
                cb.setValue2(_Value2);
                cb.setValue3(_Value3);
                sc.setAttribute("atr_CB",cb);
            }
            else{
                cb.setValue("new");
                cb.setValue1(_Value1);
                cb.setValue2(_Value2);
                cb.setValue3(_Value3);
                sc.setAttribute("atr_CB",cb);
            }
        }
        PrintWriter out = rs.getWriter();
        out.print(cb);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
