package org.calc4group.controllers;

import org.calc4group.dtos.EventDto;
import org.calc4group.entities.Event;
import org.calc4group.entities.User;
import org.calc4group.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/createEvent")
    public EventDto createEvent(EventDto eventDto) {
        return convertToDto(eventService.createEvent(eventDto));
    }

    @PostMapping("/updateEvent")
    public EventDto updateEvent(EventDto eventDto) {
        return convertToDto(eventService.updateEvent(eventDto));
    }

    @GetMapping("/all")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{eventId}")
    public EventDto getEvent(@PathVariable("eventId") Integer eventId) {
        return convertToDto(eventService.getEventById(eventId));
    }

    private EventDto convertToDto(Event event) {
        return EventDto.builder()
                .eventId(event.getEventId())
                .name(event.getName())
                .mainCurrency(event.getMainCurrency())
                .membersIds(event.getMembers().stream().map(User::getUserId).collect(Collectors.toList()))
                .build();
    }
}
