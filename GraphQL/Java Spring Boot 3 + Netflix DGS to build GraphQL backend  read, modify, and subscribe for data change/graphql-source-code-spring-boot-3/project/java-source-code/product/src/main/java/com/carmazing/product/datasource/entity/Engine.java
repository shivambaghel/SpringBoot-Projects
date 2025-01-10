package com.carmazing.product.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String description;
    private int horsePower;
    private int torque;
    private int capacityCc;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getCapacityCc() {
        return capacityCc;
    }

    public void setCapacityCc(int capacityCc) {
        this.capacityCc = capacityCc;
    }
}
