package com.carmazing.sales.datasource.repository;

import com.carmazing.sales.datasource.entity.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItem, UUID>,
        JpaSpecificationExecutor<SalesOrderItem> {

    @Query(nativeQuery = true, value = "SELECT COALESCE( SUM(s.quantity), 0) FROM sales_order_items s")
    double totalSalesQuantity();

    @Query(nativeQuery = true, value = """
           SELECT COALESCE( SUM(s.quantity), 0 )
             FROM sales_order_items s
            WHERE s.model_uuid = :modelUuid
             """)
    double modelSalesQuantity(@Param("modelUuid") UUID modelUuid);

}
