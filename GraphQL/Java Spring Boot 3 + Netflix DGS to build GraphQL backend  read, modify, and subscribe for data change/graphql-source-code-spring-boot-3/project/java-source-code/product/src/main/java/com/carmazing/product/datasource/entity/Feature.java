package com.carmazing.product.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "features")
public class Feature {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private boolean activeByDefault;
    private boolean activeByRequest;
    private int installationPrice;
    private boolean isSafety;
    private boolean isEntertainment;
    private boolean isPerformance;
    private boolean isConvenience;
    private boolean isDisplay;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActiveByDefault() {
        return activeByDefault;
    }

    public void setActiveByDefault(boolean activeByDefault) {
        this.activeByDefault = activeByDefault;
    }

    public boolean isActiveByRequest() {
        return activeByRequest;
    }

    public void setActiveByRequest(boolean activeByRequest) {
        this.activeByRequest = activeByRequest;
    }

    public int getInstallationPrice() {
        return installationPrice;
    }

    public void setInstallationPrice(int installationPrice) {
        this.installationPrice = installationPrice;
    }

    public boolean isSafety() {
        return isSafety;
    }

    public void setSafety(boolean safety) {
        isSafety = safety;
    }

    public boolean isEntertainment() {
        return isEntertainment;
    }

    public void setEntertainment(boolean entertainment) {
        isEntertainment = entertainment;
    }

    public boolean isPerformance() {
        return isPerformance;
    }

    public void setPerformance(boolean performance) {
        isPerformance = performance;
    }

    public boolean isConvenience() {
        return isConvenience;
    }

    public void setConvenience(boolean convenience) {
        isConvenience = convenience;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }
}
