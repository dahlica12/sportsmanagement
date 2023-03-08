package com.james.sportsmanagementws.coachmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coaches")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;


    private Double salary;
    private String title;

    @Embedded
    @Column(name = "coach_id")
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
