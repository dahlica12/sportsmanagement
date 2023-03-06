package com.james.sportsmanagementws.sportseventmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventResponseModel;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportResponseModel;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportsEventResponseModel;

import java.util.List;

public interface SportsEventService {

    List<SportResponseModel> getSportLeagues();
    SportsEventResponseModel getSportsLeaguesById(String sportId);
    //List<EventResponseModel> getEventsForASportsLeague();


}
