package com.james.sportsmanagementws.coachmanagementsubdomain;


import jakarta.persistence.Embedded;

public class Coach {

    @Embedded
    public CoachIdentifier coachIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;


    public Coach(CoachIdentifier coachIdentifier) {
        this.coachIdentifier = coachIdentifier;
    }




}
