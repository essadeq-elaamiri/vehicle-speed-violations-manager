package me.elaamiri.immatriculationmanagmentservice.commad.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.commands.ownerCommands.CreateOwnerCommand;
import me.elaamiri.commands.ownerCommands.DeleteOwnerCommand;
import me.elaamiri.commands.ownerCommands.UpdateOwnerCommand;
import me.elaamiri.dtos.ownerDtos.CreateOwnerRequestDTO;
import me.elaamiri.dtos.ownerDtos.UpdateOwnerRequestDTO;
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
@AllArgsConstructor
@RequestMapping("commands/owner")
public class OwnerCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createOwner(@RequestBody CreateOwnerRequestDTO createOwnerRequestDTO){
        log.info(createOwnerRequestDTO.toString());

        CompletableFuture<String> response = commandGateway.send(new CreateOwnerCommand(
                UUID.randomUUID().toString(),
                createOwnerRequestDTO.getName(),
                createOwnerRequestDTO.getBirthDate(),
                createOwnerRequestDTO.getEmail()

        ));
        return  response;
    }

    @PutMapping("/update/{id}")
    public CompletableFuture<String> updateOwner(@RequestBody UpdateOwnerRequestDTO updateOwnerRequestDTO, @PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new UpdateOwnerCommand(
                id,
                updateOwnerRequestDTO.getName(),
                updateOwnerRequestDTO.getBirthDate(),
                updateOwnerRequestDTO.getEmail()
        ));
        return  response;
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteOwner(@PathVariable String id){
        CompletableFuture<String> response = commandGateway.send(new DeleteOwnerCommand(id));
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
