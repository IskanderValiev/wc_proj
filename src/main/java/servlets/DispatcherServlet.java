package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by isko on 9/24/17.
 */
public class DispatcherServlet extends HttpServlet {

    public void forward(String to, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(to);
        dispatcher.forward(req, resp);
    }
}
