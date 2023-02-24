package com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;

import java.util.List;

public interface AthleteService {

   List<Athlete> getAthletes();
   Athlete saveAthlete(Athlete athlete);
   List<Athlete> saveAthletes(List<Athlete> athletes);

}
