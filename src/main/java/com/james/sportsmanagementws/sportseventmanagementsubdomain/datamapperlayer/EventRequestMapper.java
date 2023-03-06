package com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event.Event;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event.EventIdentifier;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportIdentifier;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventRequestModel;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.EventResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(expression = "java(eventIdentifier)", target = "eventIdentifier"),
        @Mapping(expression = "java(sportIdentifier)", target = "sportIdentifier")
    })


    Event responseModelToEntity(EventRequestModel eventRequestModel, EventIdentifier eventIdentifier, SportIdentifier sportIdentifier);

}
