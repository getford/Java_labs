package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";
    private static String in = "<label>Surname&nbsp &nbsp</label>"
            + "<input name =\"surname \" type = \"text\" width = \"150\" "
            + " maxlength= \"30\" ";

    @Override
    public int doStartTag() throws JspException {
        //return super.doStartTag();

        String in = "<form id =\"f01\" name = \"f01\" method = \"post\""
                + " action= \"" + this.action + "\">";
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("stafftag.Dossier: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
       // return super.doEndTag();

        String in = "</form>";
        JspWriter out = pageContext.getOut();
        try {
            out.print(in);
        } catch (IOException e) {
            System.out.println("stafftag.Dossier: " + e);
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
