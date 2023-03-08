package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportIdentifier;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @Column(name = "event_id")
    private EventIdentifier eventIdentifier;

    @Embedded
    @Column(name = "sport_id")
    private SportIdentifier sportIdentifier;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    private String thedate;

    private String score;

    private String duration;

    public Event() {

    }

    public Event(EventIdentifier eventIdentifier, Address address, Status status, EventType eventType) {
        this.eventIdentifier = eventIdentifier;
        this.address = address;
        this.status = status;
        this.eventType = eventType;
    }
}


