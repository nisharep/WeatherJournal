package org.example.weatherjournal.controllers;

import org.example.weatherjournal.services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherJournal {
    @Autowired
    private ObservationService observationService;

    @GetMapping
    public String weatherJournal(Model model) {
        model.addAttribute("observations", observationService.findAll());
        return "index";
    }
}
