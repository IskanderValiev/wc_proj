package sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionsImpl implements Sessions {

    @Override
    public void addSession(String name, Object value, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    @Override
    public Object getSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(name);
    }
}
