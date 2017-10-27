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
import services.clubsservices.ClubService;
import services.countriesservices.CountryService;
import services.playersservices.PlayersService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@Getter
public class PlayersController {

    private PlayersService playersService;
    private CountryService countryService;
    private ClubService clubService;

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

    @RequestMapping(value = "/playerinfo", method = RequestMethod.GET)
    public ModelAndView showPlayerInfo(HttpServletRequest request) {
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        ModelAndView modelAndView = new ModelAndView();
        String playerName = request.getParameter("playerName");
        String playerNumber = playersService.getColumnByName("player_number", playerName);
        String playerPosition = playersService.getColumnByName("player_position", playerName);
        String playerLastname = playersService.getColumnByName("player_lastname", playerName);
        String playerAge = playersService.getColumnByName("player_age", playerName);
        String playerClub = playersService.getColumnByName("player_club", playerName);
        String playerCountry = playersService.getColumnByName("player_country", playerName);
        String playerPhoto = playersService.getColumnByName("player_photo", playerName);


        modelAndView = workWithModelAndViews.showPlayerInfo(playerNumber, playerPosition, playerName, playerLastname, playerAge, playerClub, playerCountry, playerPhoto, "playerinfo");
        modelAndView.addObject("countryImage", countryService.getColumnByName("country_flag", playerCountry));
        modelAndView.addObject("clubLogo", clubService.getLogoByName(playerClub));
        return modelAndView;
    }
}
