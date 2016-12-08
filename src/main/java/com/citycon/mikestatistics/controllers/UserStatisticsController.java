package com.citycon.mikestatistics.controllers;

import com.citycon.mikestatistics.repositories.UserStatisticsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/users")
public class UserStatisticsController {
    UserStatisticsRepository repo;

    @Autowired
    public UserStatisticsController(UserStatisticsRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserStatistics(Model model) {
        model.addAttribute("usersNum", repo.getCount());
        model.addAttribute("userGroups", repo.getUsersByGroups());
        return "users";
    }
}
