package sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface Sessions {

    void addSession(String name, Object value, HttpServletRequest request);
    Object getSession(String name, HttpServletRequest request);

}
