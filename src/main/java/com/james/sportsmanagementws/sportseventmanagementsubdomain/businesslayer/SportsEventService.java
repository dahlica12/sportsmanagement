package com.james.sportsmanagementws.sportseventmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.*;

import java.util.List;
import java.util.Map;

public interface SportsEventService {

    //for sports leagues
    List<SportResponseModel> getSportLeagues();
    SportsEventResponseModel getSportsLeagueById(String sportId);
    SportResponseModel addSportsLeague(SportRequestModel sportRequestModel);
    SportResponseModel updateSportsLeague(SportRequestModel sportRequestModel, String sportId);
    void removeSportsLeague(String sportId);

    //for events
    List<EventResponseModel> getEventsInASportsLeagueByField(String sportId, Map<String, String> queryParams);
    EventResponseModel getEventInASportsLeagueByEventId(String sportId, String eventId);
    EventResponseModel addEventToASportsLeague(EventRequestModel eventRequestModel, String sportId);
    EventResponseModel updateEventInSportsLeagueBySportId(EventRequestModel eventRequestModel, String sportId, String eventId);
    void removeEventInSportsLeague(String sportId, String eventId);


}
