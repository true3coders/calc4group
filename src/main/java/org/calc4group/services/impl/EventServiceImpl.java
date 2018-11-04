package org.calc4group.services.impl;

import org.calc4group.dtos.EventDto;
import org.calc4group.entities.Event;
import org.calc4group.entities.User;
import org.calc4group.repositories.EventRepository;
import org.calc4group.services.EventService;
import org.calc4group.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, UserService userService) {
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId).get();
    }

    @Override
    public Event createEvent(EventDto eventDto) {
        Event newEvent = new Event();
        newEvent.setName(eventDto.getName());
        newEvent.setMembers(userService.getUsersByIds(eventDto.getMembersIds()));
        newEvent.setMainCurrency(eventDto.getMainCurrency());
        return eventRepository.save(newEvent);
    }

    public Event updateEvent(EventDto eventDto) {
        Optional<Event> eventOptional = eventRepository.findById(eventDto.getId());

        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setName(eventDto.getName());
            List<User> members = userService.getUsersByIds(eventDto.getMembersIds());
            event.setMembers(members);
            event.setMainCurrency(eventDto.getMainCurrency());
            return event;
        } else {
            throw new IllegalArgumentException("No such event found");
        }
    }
}
