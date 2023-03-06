package com.james.sportsmanagementws.coachmanagementsubdomain;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CoachIdentifier {

    private String coachId;

    public CoachIdentifier(String coachId) {
        this.coachId = UUID.randomUUID().toString();
    }

    public String getCoachId() {
        return coachId;
    }
}
