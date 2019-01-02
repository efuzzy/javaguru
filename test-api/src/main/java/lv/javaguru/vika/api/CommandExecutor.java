package lv.javaguru.vika.api;

import org.springframework.stereotype.Component;

import lv.javaguru.vika.api.commands.DomainCommand;
import lv.javaguru.vika.api.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
