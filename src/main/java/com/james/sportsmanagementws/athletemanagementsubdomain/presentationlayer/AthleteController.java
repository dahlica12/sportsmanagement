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

    //@GetMapping
    //public ResponseEntity<List<Athlete>> getAthletes() {
      //  return new ResponseEntity<List<Athlete>>(athleteService.getAthletes(), HttpStatus.OK) ;


    @GetMapping
    public List<AthleteResponseModel> getAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping("/{athleteId}")
    public Athlete getAthleteByAthleteId(@PathVariable String athleteId){
        return athleteService.getAthleteByAthleteId(athleteId);
    }

    @PostMapping()
    public AthleteResponseModel saveAthlete(@RequestBody Athlete athlete) {
       return athleteService.saveAthlete(athlete);
    }


    @PutMapping("/{athleteId}")
    public Athlete updateAthlete(@RequestBody Athlete athlete, @PathVariable String athleteId) {
        return athleteService.updateAthlete(athlete, athleteId);
    }

    @DeleteMapping("/{athleteId}")
    public void removeAthlete(@PathVariable String athleteId){
        athleteService.removeAthlete(athleteId);
    }








}
