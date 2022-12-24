package me.elaamiri.immatriculationmanagmentservice.commad.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.ownerCommands.DeleteOwnerCommand;
import me.elaamiri.commands.vehicleCommands.CreateVehicleCommand;
import me.elaamiri.commands.vehicleCommands.DeleteVehicleCommand;
import me.elaamiri.commands.vehicleCommands.UpdateVehicleCommand;
import me.elaamiri.dtos.vehicleDtos.CreateVehicleRequestDTO;
import me.elaamiri.dtos.vehicleDtos.UpdateVehicleRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/commands/vehicle")
@AllArgsConstructor
public class VehicleCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createVehicle(@RequestBody CreateVehicleRequestDTO createVehicleRequestDTO){
        CompletableFuture<String> response = commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                createVehicleRequestDTO.getMum_matricule(),
                createVehicleRequestDTO.getMarque(),
                createVehicleRequestDTO.getModel(),
                createVehicleRequestDTO.getPuissance_fiscal()
        ));
        return  response;
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateVehicle(@RequestBody UpdateVehicleRequestDTO updateOwnerRequestDTO, @PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new UpdateVehicleCommand(
                id,
                updateOwnerRequestDTO.getMum_matricule(),
                updateOwnerRequestDTO.getMarque(),
                updateOwnerRequestDTO.getModel(),
                updateOwnerRequestDTO.getPuissance_fiscal()
        ));
        return  response;
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteVehicle(@PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new DeleteVehicleCommand(id));
        return  response;
    }


    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );

        return responseEntity;
    }

    @GetMapping("/eventStore/{id}")
    /*
    Injected
        private EventStore eventStore;
     */
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }
}
