package cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesImpl implements Cookies{

    @Override
    public void addCookie(String name, String value, HttpServletResponse resp, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }

    @Override
    public Cookie getCookie(String name, HttpServletRequest req, HttpServletResponse response) {
        Cookie[] cookies = req.getCookies();

        Cookie cookie = null;
        for(int i = 0; i < cookies.length; i++) {
            String cookieName = cookies[i].getName();
            if (cookieName.equals(name)) {
                cookie = cookies[i];
                break;
            }
        }
        if (cookie == null) {
            cookie = new Cookie(name, "guest");
            cookie.setMaxAge(365*24*60*60);
            response.addCookie(cookie);
        }
        return cookie;
    }
}
