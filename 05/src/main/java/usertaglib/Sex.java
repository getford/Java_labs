package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Sex extends TagSupport {
    private Boolean value = false;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<label>Sex:&nbsp &nbsp</label><br/>Male <input name =\"sex\" type = \"radio\" value=\"male\"/>";
            out.print(in);
            String female = "<br/>Female <input name =\"sex\" type = \"radio\" value=\"female\"/>";
            out.print(female);
        } catch (IOException e) {
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
