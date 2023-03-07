package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "sports")
@Data
public class SportsLeague {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private SportIdentifier sportIdentifier; //public id

    private String name;


    public SportsLeague(){
        this.sportIdentifier = new SportIdentifier();
    }

    public SportsLeague(String name){
        this.sportIdentifier = new SportIdentifier();
        this.name = name;
    }

}


