package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventRequestModel {

    private String sportId;
    private String eventId;
    private String eventType;
    private String status;
    private String score;
    private String thedate;
    private String duration;
    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;
}
