package org.calc4group;

import org.calc4group.dtos.EventDto;
import org.calc4group.entities.Event;
import org.calc4group.entities.User;
import org.calc4group.repositories.EventRepository;
import org.calc4group.services.UserService;
import org.calc4group.services.impl.EventServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private UserService userService;
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventServiceImpl eventService;

    private ArgumentCaptor<Event> eventArgumentCaptor = ArgumentCaptor.forClass(Event.class);

    @Test
    public void testCreateEvent() {
        //given
        final List<User> userList = Arrays.asList(
                User.builder()
                        .userId(1)
                        .name("Lena")
                        .password("pass_1")
                        .email("lena@lena")
                        .build(),
                User.builder()
                        .userId(2)
                        .name("Evgen")
                        .password("pass_2")
                        .email("evgen@evgen")
                        .build());

        EventDto eventDto = EventDto.builder()
                .name("New event")
                .mainCurrency("UAH")
                .membersIds(Arrays.asList(1,2))
                .build();

        when(userService.getUsersByIds(any())).thenReturn(userList);

        //when
        eventService.createEvent(eventDto);

        //then
        verify(eventRepository).save(eventArgumentCaptor.capture());

        assertEquals("Wrong event name", eventDto.getName(), eventArgumentCaptor.getValue().getName());
        assertEquals("Wrong currency", eventDto.getMainCurrency(), eventArgumentCaptor.getValue().getMainCurrency());
        assertEquals("Wrong members list", userList, eventArgumentCaptor.getValue().getMembers());
    }
}
