package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventResponseModel {

    private final String eventId;
    private final String score;
    private final Date date;
    private final String duration;
    private final String streetAddress;
    private final String city;
    private final String province;
    private final String country;
    private final String postalCode;



}
