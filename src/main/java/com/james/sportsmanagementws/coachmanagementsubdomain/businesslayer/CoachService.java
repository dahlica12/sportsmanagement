package com.james.sportsmanagementws.coachmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer.AthleteResponseModel;
import com.james.sportsmanagementws.coachmanagementsubdomain.datalayer.Coach;
import com.james.sportsmanagementws.coachmanagementsubdomain.presentationlayer.CoachResponseModel;

import java.util.List;

public interface CoachService {

    List<CoachResponseModel> getCoaches();
    Coach getCoachByCoachId(String coachId);
    CoachResponseModel saveCoach(Coach coach);
    List<CoachResponseModel> saveCoaches(List<Coach> coaches);
    Coach updateCoach(Coach coach, String coachId);
    void removeCoach(String coachId);
}
