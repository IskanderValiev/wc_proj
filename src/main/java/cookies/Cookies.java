package cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Cookies {

    void addCookie(String name, String value, HttpServletResponse resp, int maxAge);

    Cookie getCookie(String name, HttpServletRequest req, HttpServletResponse response);
}
