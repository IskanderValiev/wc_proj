package sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface Sessions {

    void addSession(String name, String value, HttpServletRequest request);
    HttpSession getSession(String name, HttpServletRequest request);

}
