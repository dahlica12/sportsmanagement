package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class EventIdentifier {

    private String eventIdentifier;

    public EventIdentifier(){
        this.eventIdentifier = UUID.randomUUID().toString();
    }

    public String getEventId(){
        return eventIdentifier;
    }
}


