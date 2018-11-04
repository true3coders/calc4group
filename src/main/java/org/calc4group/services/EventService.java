package org.calc4group.services;

import org.calc4group.dtos.EventDto;
import org.calc4group.entities.Event;

import java.util.List;


public interface EventService {

    Event createEvent(EventDto eventDto);
    Event updateEvent(EventDto eventDto);
    List<Event> getAllEvents();
    Event getEventById(Integer eventId);
}
