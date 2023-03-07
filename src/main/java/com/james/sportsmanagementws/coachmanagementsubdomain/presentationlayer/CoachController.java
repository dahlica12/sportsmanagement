package com.james.sportsmanagementws.coachmanagementsubdomain.presentationlayer;

import com.james.sportsmanagementws.coachmanagementsubdomain.businesslayer.CoachService;
import com.james.sportsmanagementws.coachmanagementsubdomain.datalayer.Coach;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coaches")
public class CoachController {

    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping()
    public List<CoachResponseModel> getCoaches(){
        return coachService.getCoaches();
    }

    @GetMapping("/{coachId}")
    public Coach getCoachByCoachId(@PathVariable String coachId){
        return coachService.getCoachByCoachId(coachId);
    }

    @PostMapping()
    public CoachResponseModel saveCoach(@RequestBody Coach coach){
        return coachService.saveCoach(coach);
    }

    @PutMapping("/{coachId}")
    public Coach updateCoach(@RequestBody Coach coach, @PathVariable String coachId){
        return coachService.updateCoach(coach, coachId);
    }

    @DeleteMapping("/{coachId}")
    public void removeCoach(@PathVariable String coachId){
        coachService.removeCoach(coachId);
    }
}
