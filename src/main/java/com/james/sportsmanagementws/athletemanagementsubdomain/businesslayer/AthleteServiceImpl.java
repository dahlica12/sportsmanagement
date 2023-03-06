package com.james.sportsmanagementws.athletemanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.AthleteRepository;
import com.james.sportsmanagementws.athletemanagementsubdomain.datamapperlayer.AthleteResponseMapper;
import com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer.AthleteResponseModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService{


    private AthleteRepository athleteRepository;
    private AthleteResponseMapper athleteResponseMapper;


    public AthleteServiceImpl(AthleteRepository athleteRepository, AthleteResponseMapper athleteResponseMapper) {
        this.athleteRepository = athleteRepository;
        this.athleteResponseMapper = athleteResponseMapper;
    }


    @Override
    public List<AthleteResponseModel> getAthletes() {
        return athleteResponseMapper.entityListToResponseModelList(athleteRepository.findAll());
    }


    @Override
    public Athlete getAthleteByAthleteId(String athleteId) {
        return athleteRepository.findByAthleteIdentifier_AthleteId(athleteId);
    }


    @Override
    public AthleteResponseModel saveAthlete(Athlete newAthlete) {
        return athleteResponseMapper.entityToResponseModel(athleteRepository.save(newAthlete));
    }

    @Override
    public List<AthleteResponseModel> saveAthletes(List<Athlete> newAthletes) {
        return athleteResponseMapper.entityListToResponseModelList(athleteRepository.saveAll(newAthletes));
    }


    @Override
    public Athlete updateAthlete(Athlete athlete, String athleteId) {
        //find if athlete exists
        Athlete existingAthlete = athleteRepository.findByAthleteIdentifier_AthleteId(athleteId);

        if (existingAthlete == null){
            return null;
        }

        athlete.setId(existingAthlete.getId());
        athlete.setAthleteIdentifier(existingAthlete.getAthleteIdentifier());

        return athleteRepository.save(athlete);

    }

    @Override
    public void removeAthlete(String athleteId) {

        //find if athlete exists
        Athlete existingAthlete = athleteRepository.findByAthleteIdentifier_AthleteId(athleteId);

        if (existingAthlete == null){
            return;
        }

        athleteRepository.delete(existingAthlete);

    }


}
