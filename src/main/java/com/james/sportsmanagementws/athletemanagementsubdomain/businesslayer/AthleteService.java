package com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer.AthleteResponseModel;

import java.util.List;
import java.util.Map;


public interface AthleteService {

   List<AthleteResponseModel> getAthletes();
   Athlete getAthleteByAthleteId(String athleteId);
   AthleteResponseModel saveAthlete(Athlete athlete);
   List<AthleteResponseModel> saveAthletes(List<Athlete> athletes);
   Athlete updateAthlete(Athlete athlete, String athleteId);
   void removeAthlete(String athleteId);
   //List<Athlete> findAthletesByField (Map<String, String> queryParams);

}
