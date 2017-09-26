package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";

    @Override
    public int doStartTag() throws JspException {
        //return super.doStartTag();

        String in = "<form id =\"f01\" name = \"f01\" method = \"post\""
                + " action= \"" + this.action + "\">";
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("usertaglib.Dossier: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        // return super.doEndTag();
        int i = new Integer(10);
        System.out.println(i);
        String in = "</form>";
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("usertaglib.Dossier: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public void setValue(String s, Object o) {
        super.setValue(s, o);
    }

    @Override
    public Object getValue(String s) {
        return super.getValue(s);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
