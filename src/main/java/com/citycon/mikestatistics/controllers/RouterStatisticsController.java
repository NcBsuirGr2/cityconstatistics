package com.citycon.mikestatistics.controllers;

import com.citycon.mikestatistics.repositories.RouterStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/routers")
public class RouterStatisticsController {
    RouterStatisticsRepository repo;

    @Autowired
    public RouterStatisticsController(RouterStatisticsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showRouterStatistics(Model model) {
        model.addAttribute("routersNum", repo.getCount());
        model.addAttribute("maxConnectionRouter", repo.getMaxConnectionRouter());
        model.addAttribute("inactiveRoutersNum", repo.getInactiveRoutersNum());
        model.addAttribute("averageConnectionsPerRouter", repo.getAverageConnections());
        return "routers";
    }
}
