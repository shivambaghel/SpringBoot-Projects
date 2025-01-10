package com.carmazing.sales.resolver;

import com.carmazing.sales.generated.types.AddSalesOrderInput;
import com.carmazing.sales.generated.types.SalesOrderMutationResponse;
import com.carmazing.sales.service.command.SalesOrderCommandService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class SalesOrderResolver {

    @Autowired
    private SalesOrderCommandService salesOrderCommandService;

    @DgsMutation
    public SalesOrderMutationResponse addNewSalesOrder(
            @InputArgument AddSalesOrderInput salesOrder
            ) {
        var saved = salesOrderCommandService.addNewSalesOrder(salesOrder);

        return SalesOrderMutationResponse.newBuilder()
                .customerUuid(salesOrder.getCustomerUuid())
                .salesOrderUuid(saved.getUuid().toString())
                .orderNumber(saved.getOrderNumber())
                .success(true)
                .message(
                        String.format("New Sales Order %s created", saved.getOrderNumber())
                ).build();
    }

}
