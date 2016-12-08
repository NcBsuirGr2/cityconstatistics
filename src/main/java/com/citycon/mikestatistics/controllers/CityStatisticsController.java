package com.citycon.mikestatistics.controllers;

import com.citycon.mikestatistics.repositories.CityStatisticsRepository;
import com.citycon.mikestatistics.repositories.UserStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cities")
public class CityStatisticsController {
    CityStatisticsRepository repo;

    @Autowired
    public CityStatisticsController(CityStatisticsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String showCityStatistics(Model model) {
        model.addAttribute("citiesNum", repo.getCount());
        model.addAttribute("maxRouterCity", repo.getMaxRouterCity());
        model.addAttribute("maxConnectionCity", repo.getMaxConnectionCity());
        model.addAttribute("avgConnectionsPerCity", repo.getAverageConnections());
        return "cities";
    }
}
