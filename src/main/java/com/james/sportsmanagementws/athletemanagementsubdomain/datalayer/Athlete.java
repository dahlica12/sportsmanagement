package com.james.sportsmanagementws.athletemanagementsubdomain.datalayer;



import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "athlete")
@Data
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String sportName;

    private Float height;
    private Float weight;
    private Integer age;
    private String gender;


    @Embedded
    private AthleteIdentifier athleteIdentifier;

    @Embedded
    private Stats stats;


    @Enumerated(EnumType.STRING)
    private Status status;

    public Athlete() {
        this.athleteIdentifier = new AthleteIdentifier();
    }

    public Athlete(Stats stats, Status status) {
        this.athleteIdentifier = new AthleteIdentifier();
        this.stats = stats;
        this.status = status;
    }
}
