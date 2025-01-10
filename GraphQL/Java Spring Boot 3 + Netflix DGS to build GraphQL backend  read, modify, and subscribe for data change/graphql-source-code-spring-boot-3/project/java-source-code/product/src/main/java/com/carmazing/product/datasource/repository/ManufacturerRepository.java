package com.carmazing.product.datasource.repository;

import com.carmazing.product.datasource.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID>,
        JpaSpecificationExecutor<Manufacturer> {
}
