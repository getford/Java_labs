package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Lastname extends TagSupport {
    private String value = "";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try
        {
            String in = "<label>Surname&nbsp &nbsp</label>"
                    + "<input name =\"surname\" type = \"text\" width = \"150\" " + " maxlength= \"30\" ";
            out.print(in + (this.value.equals("") ? " " : "value =\"" + this.value + "\" />"));
        }
        catch (IOException e)
        {
            System.out.println("stafftag.Surname: " + e);
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
