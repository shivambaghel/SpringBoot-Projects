package com.carmazing.sales.service.query;

import com.carmazing.sales.datasource.repository.SalesOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesOrderItemQueryService {

    @Autowired
    private SalesOrderItemRepository salesOrderItemRepository;

    public double findModelSalesPercentage(String modelUuidString) {
        var modelUuid = UUID.fromString(modelUuidString);
        var totalSales = salesOrderItemRepository.totalSalesQuantity();
        var modelSales = salesOrderItemRepository.modelSalesQuantity(modelUuid);
        var salesPercentage = 100 * (modelSales / totalSales);

        return Math.round(salesPercentage * 10d) / 10d;
    }

}
