package com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportsLeague;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.SportRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportLeagueRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sportIdentifier", ignore = true)
    SportsLeague requestModelToEntity(SportRequestModel requestModel);
}
