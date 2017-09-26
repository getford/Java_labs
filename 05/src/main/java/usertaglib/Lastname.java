package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Lastname extends TagSupport {
    private String value = "";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<label>Lastname&nbsp &nbsp</label>"
                    + "<input name =\"lastname\" type = \"text\" width = \"150\" maxlength= \"30\" placeholder=\"Lastname\" ";
            out.print(in + (this.value.equals("") ? " " : "value =\"" + this.value + "\" />"));
        } catch (IOException e) {
            System.out.println("usertaglib.Lastname: " + e);
        }
        return SKIP_BODY;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
