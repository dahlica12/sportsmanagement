package com.james.sportsmanagementws.coachmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.coachmanagementsubdomain.datalayer.Coach;
import com.james.sportsmanagementws.coachmanagementsubdomain.datalayer.CoachRepository;
import com.james.sportsmanagementws.coachmanagementsubdomain.datamapperlayer.CoachResponseMapper;
import com.james.sportsmanagementws.coachmanagementsubdomain.presentationlayer.CoachResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService{

    private CoachRepository coachRepository;
    private CoachResponseMapper coachResponseMapper;

    public CoachServiceImpl(CoachRepository coachRepository, CoachResponseMapper coachResponseMapper) {
        this.coachRepository = coachRepository;
        this.coachResponseMapper = coachResponseMapper;
    }

    @Override
    public List<CoachResponseModel> getCoaches() {
        return coachResponseMapper.entityListToResponseModelList(coachRepository.findAll());
    }

    @Override
    public Coach getCoachByCoachId(String coachId) {
        return coachRepository.findByCoachIdentifier_CoachId(coachId);
    }

    @Override
    public CoachResponseModel saveCoach(Coach newCoach) {
        return coachResponseMapper.entityToResponseModel(coachRepository.save(newCoach));
    }

    @Override
    public List<CoachResponseModel> saveCoaches(List<Coach> newCoaches) {
        return coachResponseMapper.entityListToResponseModelList(coachRepository.saveAll(newCoaches));
    }

    @Override
    public Coach updateCoach(Coach coach, String coachId) {
        Coach existingCoach = coachRepository.findByCoachIdentifier_CoachId(coachId);

        if (existingCoach == null){
            return null;
        }

        coach.setId(existingCoach.getId());
        coach.setCoachIdentifier(existingCoach.getCoachIdentifier());

        return coachRepository.save(coach);
    }

    @Override
    public void removeCoach(String coachId) {

        Coach existingCoach = coachRepository.findByCoachIdentifier_CoachId(coachId);

        if (existingCoach == null){
            return;
        }

        coachRepository.delete(existingCoach);
    }
}
