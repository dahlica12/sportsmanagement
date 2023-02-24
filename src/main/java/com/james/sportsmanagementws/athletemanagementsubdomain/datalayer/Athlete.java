package com.james.sportsmanagementws.athletemanagementsubdomain.datalayer;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String emailAddress;


    @Embedded
    private AthleteIdentifier athleteIdentifier;

    public Athlete() {

    }

    public Athlete(String firstName, String lastName, String emailAddress, AthleteIdentifier athleteIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.athleteIdentifier = athleteIdentifier;
    }
}
