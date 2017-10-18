package controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.countriesservices.CountryService;

@Controller
@Getter
@Setter
@AllArgsConstructor
public class TeamsController {

    private CountryService countryService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView getAllCountries() {
        ModelAndView modelAndView;
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        modelAndView = workWithModelAndViews.showAllTeams(countryService.getAllCountries(), "teams");
        return modelAndView;
    }
}
