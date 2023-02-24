package com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService{

    private AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @Override
    public Athlete saveAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @Override
    public List<Athlete> saveAthletes(List<Athlete> athletes) {
        return athleteRepository.saveAll(athletes);
    }


}
