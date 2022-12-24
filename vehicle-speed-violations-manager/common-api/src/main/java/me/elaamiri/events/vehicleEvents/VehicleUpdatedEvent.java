package me.elaamiri.events.vehicleEvents;

import lombok.Getter;
import me.elaamiri.events.BaseEvent;

public class VehicleUpdatedEvent extends BaseEvent<String> {
    @Getter
    private String mum_matricule;
    @Getter
    private String marque;
    @Getter
    private int model;
    @Getter
    private float puissance_fiscal;

    public VehicleUpdatedEvent(String id, String mum_matricule, String marque, int model, float puissance_fiscal) {
        super(id);
        this.mum_matricule = mum_matricule;
        this.marque = marque;
        this.model = model;
        this.puissance_fiscal = puissance_fiscal;
    }
}
