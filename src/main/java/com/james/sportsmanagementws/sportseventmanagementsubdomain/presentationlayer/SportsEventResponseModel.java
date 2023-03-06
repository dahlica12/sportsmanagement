package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

import com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer.AthleteResponseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SportsEventResponseModel {

    private String sportId;
    private String type;
    private List<AthleteResponseModel> eventsComingUp;
}
