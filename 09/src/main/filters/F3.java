package main.filters;

import main.FltRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "F3")
public class F3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter3");
        FltRequest fltRequest = new FltRequest((HttpServletRequest)req);
        fltRequest.setAA("F1 detected!");
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        httpResponse.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
