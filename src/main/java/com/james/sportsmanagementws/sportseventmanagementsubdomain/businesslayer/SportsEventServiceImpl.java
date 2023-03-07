package com.james.sportsmanagementws.sportseventmanagementsubdomain.businesslayer;

import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.event.*;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportRepository;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datalayer.sport.SportsLeague;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.datamapperlayer.*;
import com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class SportsEventServiceImpl implements SportsEventService{

    private SportRepository sportRepository;
    private EventRepository eventRepository;
    private SportLeagueRequestMapper sportLeagueRequestMapper;
    private SportLeagueResponseMapper sportLeagueResponseMapper;
    private EventRequestMapper eventRequestMapper;
    private EventResponseMapper eventResponseMapper;
    private SportsEventResponseMapper sportsEventResponseMapper;

    public SportsEventServiceImpl(SportRepository sportRepository, EventRepository eventRepository, SportLeagueRequestMapper sportLeagueRequestMapper, SportLeagueResponseMapper sportLeagueResponseMapper, EventRequestMapper eventRequestMapper, EventResponseMapper eventResponseMapper, SportsEventResponseMapper sportsEventResponseMapper) {
        this.sportRepository = sportRepository;
        this.eventRepository = eventRepository;
        this.sportLeagueRequestMapper = sportLeagueRequestMapper;
        this.sportLeagueResponseMapper = sportLeagueResponseMapper;
        this.eventRequestMapper = eventRequestMapper;
        this.eventResponseMapper = eventResponseMapper;
        this.sportsEventResponseMapper = sportsEventResponseMapper;
    }

    @Override
    public List<SportResponseModel> getSportLeagues() {
        List<SportsLeague> sportsLeagues = sportRepository.findAll();
        return sportLeagueResponseMapper.entityListToResponseModelList(sportsLeagues);
    }

    @Override
    public SportsEventResponseModel getSportsLeagueById(String sportId) {
        SportsLeague sportsLeague = sportRepository.findBySportIdentifier_SportId(sportId);

        //check if it exists
        if (sportsLeague == null){
            return null;
        }

        List<Event> events = eventRepository.findAllBySportIdentifier_SportIdAndStatusEquals(sportId, Status.COMING_UP);
        List<EventResponseModel> eventResponseModels = eventResponseMapper.entityListToResponseModelList(events);
        return sportsEventResponseMapper.entitiesToResponseModel(sportsLeague, eventResponseModels);
    }

    @Override
    public SportResponseModel addSportsLeague(SportRequestModel sportRequestModel) {
        return sportLeagueResponseMapper.entityToResponseModel(sportRepository.save(sportLeagueRequestMapper.requestModelToEntity(sportRequestModel)));
    }

    @Override
    public SportResponseModel updateSportsLeague(SportRequestModel sportRequestModel, String sportId) {
        SportsLeague sportsLeague = sportRepository.findBySportIdentifier_SportId(sportId);

        if (sportsLeague == null){
            return null;
        }

        SportsLeague newSportsLeague = sportLeagueRequestMapper.requestModelToEntity(sportRequestModel);
        newSportsLeague.setId(sportsLeague.getId());
        newSportsLeague.setSportIdentifier(sportsLeague.getSportIdentifier());

        return sportLeagueResponseMapper.entityToResponseModel(sportRepository.save(newSportsLeague));
    }


    @Override
    public void removeSportsLeague(String sportId) {
        SportsLeague sportsLeague = sportRepository.findBySportIdentifier_SportId(sportId);

        if (sportsLeague == null){
            return;
        }

        List<Event> events = eventRepository.findAllBySportIdentifier_SportId(sportId);

        eventRepository.deleteAll(events);


        if (events.isEmpty()){

        }
        sportRepository.delete(sportsLeague);

    }

    @Override
    public List<EventResponseModel> getEventsInASportsLeagueByField(String sportId, Map<String, String> queryParams) {

        if (!sportRepository.existsBySportIdentifier_SportId(sportId)){
            return null;
        }

        //extract query params
        String eventType = queryParams.get("type");
        String status = queryParams.get("status");

        //convert to enum
        Map<String, Status> statusMap = new HashMap<>();
        statusMap.put("coming_up", Status.COMING_UP);
        statusMap.put("in_progress", Status.IN_PROGRESS);
        statusMap.put("passed", Status.PASSED);

        Map<String, EventType> eventTypeMap = new HashMap<>();
        eventTypeMap.put("game", EventType.GAME);
        eventTypeMap.put("tournament", EventType.TOURNAMENT);

        if (status != null) {
            return eventResponseMapper.entityListToResponseModelList(eventRepository.findAllBySportIdentifier_SportIdAndStatusEquals(sportId, statusMap.get(status.toLowerCase())));
        }

        if (eventType != null) {
            return eventResponseMapper.entityListToResponseModelList(eventRepository.findAllBySportIdentifier_SportIdAndEventType(sportId, eventTypeMap.get(eventType.toLowerCase())));
        }

        if(status != null && eventType != null){
            return eventResponseMapper.entityListToResponseModelList(eventRepository.findAllBySportIdentifier_SportIdAndStatusEqualsAndEventType(sportId, statusMap.get(status.toLowerCase()), eventTypeMap.get(eventType.toLowerCase())));

        }

        return eventResponseMapper.entityListToResponseModelList(
                eventRepository.findAllBySportIdentifier_SportId(sportId)
        );


    }

    @Override
    public EventResponseModel getEventInASportsLeagueByEventId(String sportId, String eventId) {
        if (!sportRepository.existsBySportIdentifier_SportId(sportId)){
            return null;
        }

        Event foundEvent = eventRepository.findBySportIdentifier_SportIdAndEventIdentifier_EventId(sportId, eventId);

        return eventResponseMapper.entityToResponseModel(foundEvent);
    }


    @Override
    public EventResponseModel addEventToASportsLeague(EventRequestModel eventRequestModel, String sportId) {

        SportsLeague sportsLeague = sportRepository.findBySportIdentifier_SportId(sportId);

        if (sportsLeague == null){
            return null;
        }

        EventIdentifier eventIdentifier = new EventIdentifier(eventRequestModel.getEventId());

        Address address = new Address(eventRequestModel.getStreetAddress(),eventRequestModel.getCity(),
                eventRequestModel.getProvince(), eventRequestModel.getCountry(), eventRequestModel.getPostalCode());

        return eventResponseMapper.entityToResponseModel
                (eventRepository.save
                (eventRequestMapper.responseModelToEntity(eventRequestModel, eventIdentifier,  sportsLeague.getSportIdentifier(), address)));
    }

    @Override
    public EventResponseModel updateEventInSportsLeagueBySportId(EventRequestModel eventRequestModel, String sportId, String eventId) {
        SportsLeague sportsLeague = sportRepository.findBySportIdentifier_SportId(sportId);
        if (sportsLeague == null){
            return null;
        }

        Event ogEvent = eventRepository.findByEventIdentifier_EventId(eventId);

        if (ogEvent == null){
            return null;
        }

        Address address = new Address(eventRequestModel.getStreetAddress(),eventRequestModel.getCity(),
                eventRequestModel.getProvince(), eventRequestModel.getCountry(), eventRequestModel.getPostalCode());

        Event updatedEvent = eventRequestMapper.responseModelToEntity(eventRequestModel, ogEvent.getEventIdentifier(), ogEvent.getSportIdentifier(), address);

        updatedEvent.setId(ogEvent.getId());

        return eventResponseMapper.entityToResponseModel(eventRepository.save(updatedEvent));


    }

    @Override
    public void removeEventInSportsLeague(String sportId, String eventId) {

        if (!sportRepository.existsBySportIdentifier_SportId(sportId)){
            return;
        }

        Event event = eventRepository.findByEventIdentifier_EventId(eventId);

        if (event == null){
            return;
        }

        eventRepository.delete(event);
    }


}
