package org.example.weatherjournal.controllers;

import org.example.weatherjournal.services.ObservationService;
import org.example.weatherjournal.models.dtos.ObservationForm;
import org.example.weatherjournal.models.entities.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/observation")
public class ObservationController {
    @Autowired
    private ObservationService observationService;

    @GetMapping("add")
    public String displayAddForm(@ModelAttribute ObservationForm observationForm) {
        return "add";
    }

    @PostMapping("add")
    public String processAddForm(@ModelAttribute @Valid ObservationForm observationForm,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "add";
        }
        Observation observation = new Observation();
        observation.setDate(observationForm.getDate());
        observation.setCloudiness(observationForm.getCloudiness());
        observation.setTempF(observationForm.getTempF());
        observationService.save(observation);
        redirectAttributes.addFlashAttribute("added", "Added observation for " + observation.getDate());
        return "redirect:/";
    }
}
