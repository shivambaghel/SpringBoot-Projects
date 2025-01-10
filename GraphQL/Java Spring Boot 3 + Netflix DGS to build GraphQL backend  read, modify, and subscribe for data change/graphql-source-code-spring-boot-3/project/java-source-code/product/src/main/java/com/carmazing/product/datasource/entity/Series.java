package com.carmazing.product.datasource.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;

    @OneToMany
    @JoinColumn(name = "series_uuid")
    @BatchSize(size = 50)
    private List<Characteristic> characteristics;

    @OneToMany(mappedBy = "series")
    @BatchSize(size = 50)
    private List<Model> models;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_uuid")
    private Manufacturer manufacturer;

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

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

}
