package cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {

    public void addCookie(String name, String value, HttpServletResponse resp) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(365*24*60*60);
        resp.addCookie(cookie);
    }

    public Cookie getCookie(String name, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();

        Cookie cookie = null;
        for(int i = 0; i < cookies.length; i++) {
            String cookieName = cookies[i].getName();
            if (cookieName.equals(name)) {
                cookie = cookies[i];
                break;
            }
        }
        return cookie;
    }
}
