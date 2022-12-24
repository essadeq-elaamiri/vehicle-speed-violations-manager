package me.elaamiri.immatriculationmanagmentservice.commad.aggregates;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.ownerCommands.CreateOwnerCommand;
import me.elaamiri.commands.ownerCommands.DeleteOwnerCommand;
import me.elaamiri.commands.ownerCommands.UpdateOwnerCommand;
import me.elaamiri.commands.radarCommands.DeleteRadarCommand;
import me.elaamiri.events.ownerEvents.OwnerCreatedEvent;
import me.elaamiri.events.ownerEvents.OwnerDeletedEvent;
import me.elaamiri.events.ownerEvents.OwnerUpdatedEvent;
import me.elaamiri.events.radarEvents.RadarDeletedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class OwnerAggregate {
    @Getter
    @AggregateIdentifier
    private String ownerId;
    @Getter
    private String name;
    @Getter
    private Date birthDate;
    @Getter
    private String email;

    public OwnerAggregate() {
    }

    @CommandHandler
    public OwnerAggregate(CreateOwnerCommand command) {

        /* TODO: validations (Name, date email ...)*/
        log.info(command.toString());
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getCommandId(),
                command.getName(),
                command.getBirthDate(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public void on(OwnerCreatedEvent event){
        this.ownerId = event.getId();
        this.birthDate = event.getBirthDate();
        this.name = event.getName();
        this.email = event.getEmail();
    }


    @CommandHandler
    public void handle(UpdateOwnerCommand command){
        // validations
        AggregateLifecycle.apply(new OwnerUpdatedEvent(
                command.getCommandId(),
                command.getName(),
                command.getBirthDate(),
                command.getEmail()

        ));

        /* TODO: validate if the radar exists*/

    }

    @EventSourcingHandler
    public void on(OwnerUpdatedEvent event){
        this.ownerId = event.getId();
        this.birthDate = event.getBirthDate();
        this.name = event.getName();
        this.email = event.getEmail();
    }

    @CommandHandler
    public void handle(DeleteOwnerCommand command){
        // validations
        AggregateLifecycle.apply(new OwnerDeletedEvent(
                command.getCommandId()
        ));

        /* TODO: validate if the radar exists*/

    }

    @EventSourcingHandler
    public void on(OwnerDeletedEvent event){
        log.warn("Deleting Owner: "+ event.getId());
    }
}
