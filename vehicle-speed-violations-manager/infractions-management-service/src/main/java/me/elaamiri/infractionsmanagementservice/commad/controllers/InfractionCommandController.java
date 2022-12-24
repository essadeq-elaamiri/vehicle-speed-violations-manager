package me.elaamiri.infractionsmanagementservice.commad.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.infractionCommands.CreateInfractionCommand;
import me.elaamiri.commands.infractionCommands.DeleteInfractionCommand;
import me.elaamiri.commands.infractionCommands.UpdateInfractionCommand;
import me.elaamiri.dtos.infractionDtos.CreateInfractionRequestDTO;
import me.elaamiri.dtos.infractionDtos.UpdateInfractionRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/commands/infraction")
public class InfractionCommandController {
    private CommandGateway commandGateway;

    @PostMapping("create")
    public CompletableFuture<String> createInfraction(@RequestBody CreateInfractionRequestDTO createInfractionRequestDTO){
        return commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                createInfractionRequestDTO.getDate(),
                createInfractionRequestDTO.getViresse(),
                createInfractionRequestDTO.getMontant(),
                createInfractionRequestDTO.getVehiculeId(),
                createInfractionRequestDTO.getRadarId()
        ));
    }

    @PutMapping("update/{id}")
    public CompletableFuture<String> updateInfraction(@RequestBody UpdateInfractionRequestDTO updateInfractionRequestDTO, @PathVariable String id){
        return commandGateway.send(new UpdateInfractionCommand(
                id,
                updateInfractionRequestDTO.getDate(),
                updateInfractionRequestDTO.getViresse(),
                updateInfractionRequestDTO.getMontant(),
                updateInfractionRequestDTO.getVehiculeId(),
                updateInfractionRequestDTO.getRadarId()
        ));
    }

    @DeleteMapping("delete/{id}")
    public CompletableFuture<String> deleteInfraction(@PathVariable String id){
        return commandGateway.send(new DeleteInfractionCommand(id));
    }


}
