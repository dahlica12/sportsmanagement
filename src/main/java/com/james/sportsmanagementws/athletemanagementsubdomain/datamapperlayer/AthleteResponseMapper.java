package com.james.sportsmanagementws.athletemanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.datalayer.Athlete;
import com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer.AthleteResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AthleteResponseMapper {

    @Mapping(expression = "java(athlete.getAthleteIdentifier().getAthleteId())",
            target = "athleteId")
    @Mapping(expression = "java(athlete.getStats().getPointsWon())", target = "pointsWon")
    @Mapping(expression = "java(athlete.getStats().getGamesWon())", target = "gamesWon")
    @Mapping(expression = "java(athlete.getStats().getGamesLost())", target = "gamesLost")

    AthleteResponseModel entityToResponseModel(Athlete athlete);

   List<AthleteResponseModel> entityListToResponseModelList(List<Athlete> athletes);
}
