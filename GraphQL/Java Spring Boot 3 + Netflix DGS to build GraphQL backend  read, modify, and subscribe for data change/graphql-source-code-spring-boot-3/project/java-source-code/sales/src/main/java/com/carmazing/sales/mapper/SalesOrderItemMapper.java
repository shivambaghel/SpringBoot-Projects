package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.SalesOrderItem;
import com.carmazing.sales.generated.types.SalesOrderItemInput;

import java.util.UUID;

public class SalesOrderItemMapper {

    public static SalesOrderItem mapToEntity(SalesOrderItemInput original) {
        var mapped = new SalesOrderItem();

        mapped.setModelUuid(
                UUID.fromString(original.getModelUuid())
        );
        mapped.setQuantity(original.getQuantity());

        return mapped;
    }

    public static com.carmazing.sales.generated.types.SalesOrderItem mapToGraphqlEntity(
            SalesOrderItem original) {
        var mapped = new com.carmazing.sales.generated.types.SalesOrderItem();

        mapped.setUuid(original.getUuid().toString());
        mapped.setModelUuid(original.getModelUuid().toString());
        mapped.setQuantity(original.getQuantity());

        return mapped;
    }

}
