package com.carmazing.product.datasource.repository;

import com.carmazing.product.datasource.entity.Manufacturer;
import com.carmazing.product.datasource.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID>,
        JpaSpecificationExecutor<Series> {
}
