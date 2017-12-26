package main.filters;

import main.FltRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "F2")
public class F2 implements Filter {
    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter2");
        FltRequest fltRequest = new FltRequest((HttpServletRequest)req);
        fltRequest.setAA("F2 detected!");
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        httpResponse.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
