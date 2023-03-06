package com.james.sportsmanagementws.athletemanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AthleteResponseModel {

    private final String athleteId;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String sportName;
    private final Integer pointsWon;
    private final Integer gamesWon;
    private final Integer gamesLost;
    private final Float height;
    private final Float weight;
    private final Integer age;
    private final String gender;



}
