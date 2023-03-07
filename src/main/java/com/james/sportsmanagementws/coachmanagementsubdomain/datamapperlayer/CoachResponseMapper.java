package com.james.sportsmanagementws.coachmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.coachmanagementsubdomain.datalayer.Coach;

import com.james.sportsmanagementws.coachmanagementsubdomain.presentationlayer.CoachResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoachResponseMapper {

    @Mapping(expression = "java(coach.getCoachIdentifier().getCoachId())",
    target = "coachId")
   // @Mapping(expression = "java(coach.getPosition().getTitle())", target = "title")
   // @Mapping(expression = "java(coach.getPosition().getYearsInPosition())", target = "yearsInPosition")

    CoachResponseModel entityToResponseModel(Coach coach);

    List<CoachResponseModel> entityListToResponseModelList(List<Coach> coaches);
}
