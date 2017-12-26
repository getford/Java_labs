package main.filters;

import main.FltRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "F1")
public class F1 implements javax.servlet.Filter {

    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter1");
        FltRequest fltRequest = new FltRequest((HttpServletRequest)req);
        fltRequest.setAA("F1 detected!");
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        httpResponse.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    public void init(FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("init");
    }

}
