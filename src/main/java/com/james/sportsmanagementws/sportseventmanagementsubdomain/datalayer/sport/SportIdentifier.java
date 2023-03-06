package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SportIdentifier {

    private String sportId;

    public SportIdentifier() {
        this.sportId = UUID.randomUUID().toString();
    }

    public String getSportId() {
        return sportId;
    }
}


