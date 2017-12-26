package main.listener; /**
 * Created by User on 19.10.2017.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class L2 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public L2() {
    }


    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeAdded:AtributeName= "+sbe.getName());
        System.out.println("Lst2:attributeAdded:AtributeValue "+sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("L2:Removed");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("L2:Replaced");
    }
}
