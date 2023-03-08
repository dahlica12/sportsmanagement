package com.james.sportsmanagementws.athletemanagementsubdomain.datalayer;



import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "athletes")
@Data
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "sport_name")
    private String sportName;

    private Float height;
    private Float weight;
    private Integer age;
    private String gender;


    @Embedded
    @Column(name = "athlete_id")
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
