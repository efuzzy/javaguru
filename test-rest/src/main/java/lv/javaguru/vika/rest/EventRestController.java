package lv.javaguru.vika.rest;

import lv.javaguru.vika.api.commands.events.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lv.javaguru.vika.api.CommandExecutor;
import lv.javaguru.vika.commons.dtos.EventDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(
        value = "/events",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class EventRestController {

    private CommandExecutor commandExecutor;

    @Autowired
    public EventRestController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @RequestMapping(method = RequestMethod.POST, value="/add")
    @ResponseBody
    public EventDTO create(EventDTO eventDTO) {
        CreateEventCommand command = new CreateEventCommand(
                eventDTO.getEventName()
        );
        CreateEventResult result = commandExecutor.execute(command);
        return result.getEvent();
    }

    @GetMapping("/get/{eventId}")
    @ResponseBody
    public EventDTO get(@PathVariable("eventId") Long eventId) {
        GetEventCommand command = new GetEventCommand(eventId);
        GetEventResult result = commandExecutor.execute(command);
        return result.getEvent();
    }

    @GetMapping("/test")
    @ResponseBody
    public String welcomeUser() {
        return "hi!";
    }

    @GetMapping("/get/")
    @ResponseBody
    public List<EventDTO> getAllEvents() {
        GetAllEventsCommand command = new GetAllEventsCommand();
        GetAllEventsResult result = commandExecutor.execute(command);
        return new ArrayList<>();
    }

}
