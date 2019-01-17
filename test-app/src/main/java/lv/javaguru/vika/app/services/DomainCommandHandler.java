package lv.javaguru.vika.app.services;

import lv.javaguru.vika.api.commands.DomainCommand;
import lv.javaguru.vika.api.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
