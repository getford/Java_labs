package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FltRequest extends HttpServletRequestWrapper implements HttpServletRequest {
    public String AA = null;
    public String BB = null;

    public FltRequest(HttpServletRequest request) {
        super(request);
    }

    public String getAA() {
        return AA;
    }

    public void setAA(String AA) {
        this.AA = AA;
    }

    public String getBB() {
        return BB;
    }

    public void setBB(String BB) {
        this.BB = BB;
    }
}
