package io.sankalp.coronavirustracker.controllers;

import io.sankalp.coronavirustracker.models.LocationStats;
import io.sankalp.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home (Model model) {
        final List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        final int totalReportedCases = allStats.stream()
                                               .mapToInt(stats -> stats.getLatestReportedTotalCases())
                                               .sum();
        final int totalNewCases = allStats.stream()
                                          .mapToInt(stats -> stats.getDifferenceFromPreviousDay())
                                          .sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
