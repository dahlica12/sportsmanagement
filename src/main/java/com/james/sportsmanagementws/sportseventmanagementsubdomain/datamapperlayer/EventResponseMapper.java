package com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event.Event;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {

    @Mapping(expression = "java(event.getEventIdentifier().getEventId())", target = "eventIdentifier")
    @Mapping(expression = "java(event.getSportIdentifier().getSportId())", target = "sportId")
    @Mapping(expression = "java(event.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(event.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(event.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(event.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(event.getAddress().getPostalCode())", target = "postalCode")

    EventResponseModel entityToResponseModel(Event event);

    List<EventResponseModel> entityListToResponseModelList(List<Event> events);

}
