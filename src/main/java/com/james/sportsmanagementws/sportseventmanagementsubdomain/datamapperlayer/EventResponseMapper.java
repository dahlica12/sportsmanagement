package com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event.Event;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {

    @Mapping(expression = "java(event.getEventIdentifier().getEventId())", target = "eventId")
    @Mapping(expression = "java(event.getSportIdentifier().getSportId())", target = "sportId")

    EventResponseModel entityToResponseModel(Event event);

    List<EventResponseModel> entityListToResponseModelList(List<Event> events);

}
