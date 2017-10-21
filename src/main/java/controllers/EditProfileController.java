package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import encoders.Encoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.usersservices.UsersService;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
@AllArgsConstructor
@Getter
public class EditProfileController {

    private UsersService usersService;

    @RequestMapping(value = "/editprofile", method = RequestMethod.GET)
    public ModelAndView editProfile(HttpServletRequest request) {
        ModelAndView modelAndView;
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request);
        String login = Encoder.decryptCookie("iskander", cookie.getValue());
        System.out.println(login);
        String name = usersService.getParameterByLogin("name", login);
        String lastname = usersService.getParameterByLogin("lastname", login);
        String gender = usersService.getParameterByLogin("gender", login);
        String bday = usersService.getParameterByLogin("bday", login);
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        String image = usersService.getParameterByLogin("photo", login);
        modelAndView = workWithModelAndViews.showUsersData(login, name, lastname, gender, bday, city, telephone, email, image, "editprofile");
        return modelAndView;
    }

    @RequestMapping(value = "/editprofile", method = RequestMethod.POST)
    public ModelAndView submitChanges(HttpServletRequest request) throws LoginException, NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();

        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request);
        String login = Encoder.decryptCookie("iskander", cookie.getValue());

        String newName = request.getParameter("name");
        String newLastname = request.getParameter("lastname");
        String currPass = request.getParameter("currpass");
        String newPass = request.getParameter("newpass");
        String confNewPass = request.getParameter("cnewpass");
        String newBday = request.getParameter("bday") + " " + request.getParameter("bmon") + " " + request.getParameter("byear");
        String newCity = request.getParameter("city");
        String newGender = request.getParameter("gender");
        String newEmail = request.getParameter("email");
        String newTelephone = request.getParameter("telephone");
        String newInstagram = request.getParameter("instagram");
        String newImage = request.getParameter("image");

        String name = usersService.getParameterByLogin("name", login);
        String lastname = usersService.getParameterByLogin("lastname", login);
        String gender = usersService.getParameterByLogin("gender", login);
        String bday = usersService.getParameterByLogin("bday", login);
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        String image = usersService.getParameterByLogin("photo", login);

        if (!newName.equals(name) && !newName.equals("")) {
            usersService.updateUsersData(login, "name", newName);
        }
        if (!newLastname.equals(lastname) && !newLastname.equals("")) {
            usersService.updateUsersData(login, "lastname", newLastname);
        }
        if(!newPass.equals(currPass) && newPass.equals(confNewPass)) {
            String salt = Encoder.salt();
            usersService.updateUsersData(login, "password", Encoder.encrypt(salt + newPass));
            usersService.updateUsersData(login, "salt", salt);
        }
        System.out.println(newGender);
        if (!newGender.equals(gender) && !newGender.equals("")) {
            usersService.updateUsersData(login, "gender", newGender);
        }
        if (!newBday.equals(bday) && !newBday.equals("")) {
            usersService.updateUsersData(login, "bday", newBday);
        }
        if(!newCity.equals(city)) {
            usersService.updateUsersData(login, "city", newCity);
        }
        if (!newTelephone.equals(telephone) && !newTelephone.equals("")) {
            usersService.updateUsersData(login, "telephone", newTelephone);
        }
        if (!newEmail.equals(email) && !newEmail.equals("")) {
            usersService.updateUsersData(login, "email", newEmail);
        }
//        if (!newInstagram.equals("")) {
//            usersService.updateUsersData(login, "instagram", newInstagram);
//        }
        if (!newImage.equals("")) {
            usersService.updateUsersData(login, "photo", newImage);
        }
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

}
