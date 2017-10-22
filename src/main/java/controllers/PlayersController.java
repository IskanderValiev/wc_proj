package controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import models.Club;
import models.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.playersservices.PlayersService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@Getter
public class PlayersController {

    private PlayersService playersService;

    @RequestMapping(value = "/squad", method = RequestMethod.GET)
    public ModelAndView setSquad(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String country = request.getParameter("countryName");
        System.out.println(country);
        modelAndView.addObject("countryName", country);
        System.out.println("players: " + playersService.getAllPlayersByCountry(country));
        modelAndView.addObject("players", playersService.getAllPlayersByCountry(country));
        modelAndView.setViewName("players");
        return modelAndView;
    }
//
//    @RequestMapping(value = "/playerinfo", method = RequestMethod.GET)
//    public ModelAndView showPlayerInfo(HttpServletRequest request) {
//
//    }
}
