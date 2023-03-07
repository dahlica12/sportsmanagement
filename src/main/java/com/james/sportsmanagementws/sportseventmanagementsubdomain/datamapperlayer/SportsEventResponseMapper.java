package com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportsLeague;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventResponseModel;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportsEventResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportsEventResponseMapper {

    @Mapping(expression = "java(sportsLeague.getSportIdentifier().getSportId())", target = "sportId")
    @Mapping(expression = "java(events)", target = "eventsComingUp")
    SportsEventResponseModel entitiesToResponseModel(SportsLeague sportsLeague, List<EventResponseModel> events);


}
