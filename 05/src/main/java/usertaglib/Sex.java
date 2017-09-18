package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Sex extends TagSupport {
    private static String in = "<label>Sex:&nbsp &nbsp</label><br/>" + "Male <input name =\"sex\" type = \"radio\" value=\"male\"/>";
    private static String female = "<br/><label>Female&nbsp</label>" + "<input name =\"sex\" type = \"radio\" value=\"female\"/>";
    private Boolean value = false;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try
        {
            out.print(in );
            out.print(female);
        }
        catch (IOException e)
        {
            System.out.println("stafftag.Sex: " + e);
        }
        return SKIP_BODY;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
