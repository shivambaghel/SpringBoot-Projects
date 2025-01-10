package com.carmazing.sales.datasource.repository;

import com.carmazing.sales.datasource.entity.Customer;
import com.carmazing.sales.datasource.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, UUID>,
        JpaSpecificationExecutor<SalesOrder> {
}
