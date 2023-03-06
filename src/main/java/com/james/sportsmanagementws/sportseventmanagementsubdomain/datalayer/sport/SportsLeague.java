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
    SportIdentifier sportIdentifier; //public id

    private String type;


    public SportsLeague(){
        this.sportIdentifier = new SportIdentifier();
    }

    public SportsLeague(String type){
        this.sportIdentifier = new SportIdentifier();
        this.type = type;
    }

}


