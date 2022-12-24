package me.elaamiri.immatriculationmanagmentservice.commad.aggregates;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.ownerCommands.DeleteOwnerCommand;
import me.elaamiri.commands.vehicleCommands.CreateVehicleCommand;
import me.elaamiri.commands.vehicleCommands.DeleteVehicleCommand;
import me.elaamiri.commands.vehicleCommands.UpdateVehicleCommand;
import me.elaamiri.events.ownerEvents.OwnerDeletedEvent;
import me.elaamiri.events.vehicleEvents.VehicleCreatedEvent;
import me.elaamiri.events.vehicleEvents.VehicleDeletedEvent;
import me.elaamiri.events.vehicleEvents.VehicleUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j

public class VehicleAggregate {

    @AggregateIdentifier
    @Getter
    private String vehicleId;

    @Getter
    private String mum_matricule;

    @Getter
    private String marque;

    @Getter
    private int model;

    @Getter
    private float puissance_fiscal;

    public VehicleAggregate() {
    }

    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand command) {
        /* TODO: validations

         */

        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getCommandId(),
                command.getMum_matricule(),
                command.getMarque(),
                command.getModel(),
                command.getPuissance_fiscal()
        ));
    }

    @EventSourcingHandler
    public void on(VehicleCreatedEvent event){
        this.vehicleId = event.getId();
        this.marque = event.getMarque();
        this.model = event.getModel();
        this.puissance_fiscal= event.getPuissance_fiscal();
        this.mum_matricule = event.getMum_matricule();
    }


    @CommandHandler
    public void handle(UpdateVehicleCommand command){
        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getCommandId(),
                command.getMum_matricule(),
                command.getMarque(),
                command.getModel(),
                command.getPuissance_fiscal()
        ));
    }

    @EventSourcingHandler
    public void on(VehicleUpdatedEvent event){
        this.vehicleId = event.getId();
        this.marque = event.getMarque();
        this.model = event.getModel();
        this.puissance_fiscal= event.getPuissance_fiscal();
        this.mum_matricule = event.getMum_matricule();
    }

    @CommandHandler
    public void handle(DeleteVehicleCommand command){
        // validations
        AggregateLifecycle.apply(new VehicleDeletedEvent(
                command.getCommandId()
        ));

        /* TODO: validate if the radar exists*/

    }

    @EventSourcingHandler
    public void on(VehicleDeletedEvent event){
        log.warn("Deleting Vehicle: "+ event.getId());
    }



}
