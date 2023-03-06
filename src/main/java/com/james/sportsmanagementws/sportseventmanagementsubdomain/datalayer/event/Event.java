package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportIdentifier;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    public EventIdentifier eventIdentifier;

    @Embedded
    public SportIdentifier sportIdentifier;

    @Embedded
    public Address address;


    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private Date date;

    private String score;

    private String duration;

    public Event() {

    }

    public Event(EventIdentifier eventIdentifier, Address address, Status status, EventType type) {
        this.eventIdentifier = eventIdentifier;
        this.address = address;
        this.status = status;
        this.type = type;
    }
}


