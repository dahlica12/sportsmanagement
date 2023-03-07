package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class EventIdentifier {

    private String eventId;

    public EventIdentifier(){

    }

    public EventIdentifier(String eventId){
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId(){
        return eventId;

    }
}


