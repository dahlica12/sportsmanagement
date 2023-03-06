package com.james.sportsmanagementws.sportseventmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportResponseModel;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportsEventResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsEventServiceImpl implements SportsEventService{



    @Override
    public List<SportResponseModel> getSportLeagues() {
        return null;
    }

    @Override
    public SportsEventResponseModel getSportsLeaguesById(String sportId) {
        return null;
    }
}
