package me.elaamiri.commands.ownerCommands;

import lombok.Getter;
import me.elaamiri.commands.BaseCommand;

import java.util.Date;

public class UpdateOwnerCommand extends BaseCommand<String> {
    @Getter
    private String name;
    @Getter
    private Date birthDate;
    @Getter
    private String email;

    public UpdateOwnerCommand(String commandId, String name, Date birthDate, String email) {
        super(commandId);
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }
}
