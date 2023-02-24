package com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer.AthleteService;
import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/athletes")
public class AthleteController {

    private AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public ResponseEntity<List<Athlete>> getAthletes() {
        return new ResponseEntity<List<Athlete>>(athleteService.getAthletes(), HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<Athlete> saveAthlete(@RequestBody Athlete athlete) {
        return new ResponseEntity<Athlete>(athleteService.saveAthlete(athlete), HttpStatus.CREATED);
    }

    @PostMapping("/many")
    public ResponseEntity<List<Athlete>> saveAthletes(@RequestBody List<Athlete> athletes) {
        return new ResponseEntity<List<Athlete>>(athleteService.saveAthletes(athletes), HttpStatus.CREATED);
    }


}
