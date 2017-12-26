package main.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class L1 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public L1() {
        System.out.println("L1: constructor");
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}
