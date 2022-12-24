package me.elaamiri.commands.vehicleCommands;

import lombok.Getter;
import me.elaamiri.commands.BaseCommand;

public class CreateVehicleCommand extends BaseCommand<String> {
    @Getter
    private String mum_matricule;
    @Getter
    private String marque;
    @Getter
    private int model;
    @Getter
    private float puissance_fiscal;

    public CreateVehicleCommand(String commandId, String mum_matricule, String marque, int model, float puissance_fiscal) {
        super(commandId);
        this.mum_matricule = mum_matricule;
        this.marque = marque;
        this.model = model;
        this.puissance_fiscal = puissance_fiscal;
    }
}
