package me.elaamiri.commands.infractionCommands;

import lombok.Getter;
import me.elaamiri.commands.BaseCommand;

import java.util.Date;

public class UpdateInfractionCommand extends BaseCommand<String> {
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

    public UpdateInfractionCommand(String commandId, Date date, double viresse, double montant, String vehiculeId, String radarId) {
        super(commandId);
        this.date = date;
        this.viresse = viresse;
        this.montant = montant;
        this.vehiculeId = vehiculeId;
        this.radarId = radarId;
    }
}
