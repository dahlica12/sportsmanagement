package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer.AthleteService;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.businesslayer.SportsEventService;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportsLeague;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/v1/sports")
public class SportsEventController {

   public SportsEventService sportsEventService;

    public SportsEventController(SportsEventService sportsEventService) {
        this.sportsEventService = sportsEventService;
    }

    @GetMapping
    List<SportResponseModel> getSportsLeagues(){
        return sportsEventService.getSportLeagues();
    }

    @GetMapping("/{sportId}")
    SportsEventResponseModel getSportsLeagueById(@PathVariable String sportId) {
        return sportsEventService.getSportsLeagueById(sportId);
    }

    @PostMapping()
    SportResponseModel addSportsLeague(@RequestBody SportRequestModel sportRequestModel){
        return sportsEventService.addSportsLeague(sportRequestModel);
    }

    @PutMapping("/{sportId}")
    SportResponseModel updateSportLeagueDetails(@RequestBody SportRequestModel sportRequestModel, @PathVariable String sportId){
        return sportsEventService.updateSportsLeague(sportRequestModel, sportId);
    }

    @DeleteMapping("/{sportId}")
    void deleteSportsLeague(@PathVariable String sportId){
        sportsEventService.removeSportsLeague(sportId);
    }

    @GetMapping("/{sportId}/events")
    List<EventResponseModel> getEventsInASportsLeague(@PathVariable String sportId, @RequestParam(required = false)Map<String, String> queryParams) {
        return sportsEventService.getEventsInASportsLeagueByField(sportId, queryParams);
    }

    @GetMapping("/{sportId}/events/{eventId}")
    EventResponseModel getEventInASportsLeagueByEventId(@PathVariable String sportId, @PathVariable String eventId){
        return sportsEventService.getEventInASportsLeagueByEventId(sportId, eventId);
    }

    @PostMapping("/{sportId}/events")
    EventResponseModel addEventToASportsLeague(@PathVariable String sportId, @RequestBody EventRequestModel eventRequestModel){
        return sportsEventService.addEventToASportsLeague(eventRequestModel, sportId);
    }

    @PutMapping("/{sportId}/events/{eventId}")
    EventResponseModel updateEventInSportsLeagueBySportId(@RequestBody EventRequestModel eventRequestModel, @PathVariable String sportId, @PathVariable String eventId){
        return sportsEventService.updateEventInSportsLeagueBySportId(eventRequestModel, sportId, eventId);
    }

    @DeleteMapping("/{sportId}/events/{eventId}")
    void removeEventInSportsLeague(@PathVariable String sportId, @PathVariable String eventId){
        sportsEventService.removeEventInSportsLeague(sportId, eventId);
    }


}


