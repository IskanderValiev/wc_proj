package listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml");
        servletContextEvent.getServletContext().setAttribute("context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
