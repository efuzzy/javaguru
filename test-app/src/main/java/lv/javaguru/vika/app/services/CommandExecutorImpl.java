package lv.javaguru.vika.app.services;

import lv.javaguru.vika.api.CommandExecutor;
import lv.javaguru.vika.api.commands.DomainCommand;
import lv.javaguru.vika.api.commands.DomainCommandResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class CommandExecutorImpl implements CommandExecutor {

    @Autowired
    private List<DomainCommandHandler> commandHandlers;

    private Map<Class, DomainCommandHandler> commandHandlersMap;


    @PostConstruct
    public void init() {
        commandHandlersMap = new HashMap<>();
        if(commandHandlers != null && !commandHandlers.isEmpty()) {
            for (DomainCommandHandler service : commandHandlers) {
                Class domainCommandClass = service.getCommandType();
                commandHandlersMap.put(domainCommandClass, service);
            }
        }
    }

    @Transactional()
    public <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand) {
        DomainCommandHandler service = commandHandlersMap.get(domainCommand.getClass());
        if(service != null) {
            return (T)service.execute(domainCommand);
        } else {
            throw new IllegalArgumentException("Unknown domain command! " + domainCommand.toString());
        }
    }

}
