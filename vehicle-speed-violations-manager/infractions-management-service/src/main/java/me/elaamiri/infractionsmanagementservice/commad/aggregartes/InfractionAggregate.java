package me.elaamiri.infractionsmanagementservice.commad.aggregartes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.infractionCommands.CreateInfractionCommand;
import me.elaamiri.events.infractionEvents.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@AllArgsConstructor
@Slf4j
public class InfractionAggregate {

    @Getter
    private String id;

    @Getter
    private Date date;

    @Getter
    private double viresse;

    @Getter
    private double montant;
    @Getter
    private String vehiculeId;

    @Getter
    private String radarId;

    public InfractionAggregate() {
    }


    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        /*TODO: validations*/
        AggregateLifecycle.apply(new InfractionCreatedEvent(
            command.getRadarId(),command.getDate(), command.getViresse(), command.getMontant(), command.getVehiculeId(),command.getRadarId()
        ));
    }

    @EventSourcingHandler
    public void on(InfractionCreatedEvent event){
        this.id = event.getId();
        this.date = event.getDate();
        this.montant = event.getMontant();
        this.viresse = event.getViresse();
        this.radarId = event.getRadarId();
        this.vehiculeId = event.getVehiculeId();
    }

}
