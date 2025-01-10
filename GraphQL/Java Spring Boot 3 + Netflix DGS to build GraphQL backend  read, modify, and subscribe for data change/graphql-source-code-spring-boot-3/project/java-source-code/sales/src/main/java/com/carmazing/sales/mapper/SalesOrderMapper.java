package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.SalesOrder;
import com.carmazing.sales.generated.types.AddSalesOrderInput;
import org.apache.commons.lang3.RandomStringUtils;

public class SalesOrderMapper {

    public static SalesOrder mapToEntity(AddSalesOrderInput original) {
        var mapped = new SalesOrder();

        mapped.setOrderNumber(generateOrderNumber());

        var mappedFinance = FinanceMapper.mapToEntity(original.getFinance());
        mappedFinance.setSalesOrder(mapped);
        mapped.setFinance(mappedFinance);

        var salesOrderItemsEntity = original.getSalesOrderItems()
                .stream().map(SalesOrderItemMapper::mapToEntity).toList();
        mapped.setSalesOrderItems(salesOrderItemsEntity);

        return mapped;
    }

    private static String generateOrderNumber() {
        return "SALES-" + RandomStringUtils.randomAlphabetic(8).toUpperCase();
    }

    public static com.carmazing.sales.generated.types.SalesOrder mapToGraphqlEntity(SalesOrder original) {
        var mapped = new com.carmazing.sales.generated.types.SalesOrder();
        var mappedFinance = FinanceMapper.mapToGraphqlEntity(original.getFinance());
        var mappedSalesOrderItems = original.getSalesOrderItems().stream()
                .map(SalesOrderItemMapper::mapToGraphqlEntity)
                .toList();

        mapped.setFinance(mappedFinance);
        mapped.setSalesOrderItems(mappedSalesOrderItems);
        mapped.setUuid(original.getUuid().toString());
        mapped.setOrderNumber(original.getOrderNumber());
        mapped.setOrderDateTime(original.getOrderDateTime());

        return mapped;
    }

}
