package me.elaamiri.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<TDType> {

    @Getter
    @TargetAggregateIdentifier
    private TDType commandId;

    public BaseCommand(TDType commandId) {
        this.commandId = commandId;
    }
}
