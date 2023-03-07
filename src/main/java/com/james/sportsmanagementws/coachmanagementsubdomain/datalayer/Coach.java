package com.james.sportsmanagementws.coachmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coach")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;


    private Double salary;
    private String title;

    @Embedded
    private CoachIdentifier coachIdentifier;

    //@Embedded
    //private Position position;

    public Coach() {
        this.coachIdentifier = new CoachIdentifier();
    }

    /*
    public Coach(Position position) {
        this.coachIdentifier = new CoachIdentifier();
        this.position = position;
    }

     */
}
