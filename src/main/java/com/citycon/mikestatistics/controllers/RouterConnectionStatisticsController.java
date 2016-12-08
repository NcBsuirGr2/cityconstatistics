package com.citycon.mikestatistics.controllers;

import com.citycon.mikestatistics.repositories.RouterConnectionStatisticsRepository;
import com.citycon.mikestatistics.repositories.RouterStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/connections")
public class RouterConnectionStatisticsController {
    RouterConnectionStatisticsRepository repo;

    @Autowired
    public RouterConnectionStatisticsController(RouterConnectionStatisticsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showConnectionStatistics(Model model) {
        model.addAttribute("connectionsNum", repo.getCount());
        model.addAttribute("inactiveConnectionsNum", repo.getInactiveConnectionsNum());
        return "connections";
    }
}
