package com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllBySportIdentifier_SportId(String sportId);
    List<Event> findAllBySportIdentifier_SportIdAndStatusEquals(String sportId, Status status);
    List<Event> findAllBySportIdentifier_SportIdAndEventType(String sportId, EventType eventType);
    List<Event> findAllBySportIdentifier_SportIdAndStatusEqualsAndEventType(String sportId, Status status, EventType eventType);
    Event findBySportIdentifier_SportIdAndEventIdentifier_EventId(String sportId, String eventId);
    Event findByEventIdentifier_EventId(String eventId);

}
