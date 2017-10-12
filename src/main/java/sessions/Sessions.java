package sessions;

import javax.servlet.http.HttpSession;

public interface Sessions {

    void addSession();
    HttpSession getSession();
}
