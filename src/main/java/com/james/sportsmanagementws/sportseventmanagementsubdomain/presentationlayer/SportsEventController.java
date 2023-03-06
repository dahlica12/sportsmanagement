package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer.AthleteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/sports")
public class SportsEventController {

   public AthleteService athleteService;

    public SportsEventController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }
}


