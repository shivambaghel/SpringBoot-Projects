package com.carmazing.sales.service.command;

import com.carmazing.sales.datasource.entity.SalesOrder;
import com.carmazing.sales.datasource.repository.CustomerRepository;
import com.carmazing.sales.datasource.repository.SalesOrderRepository;
import com.carmazing.sales.generated.types.AddSalesOrderInput;
import com.carmazing.sales.mapper.SalesOrderMapper;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalesOrderCommandService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public SalesOrder addNewSalesOrder(AddSalesOrderInput addSalesOrderInput) {
        var existingCustomer = customerRepository.findById(
                UUID.fromString(addSalesOrderInput.getCustomerUuid())
        );

        if (existingCustomer.isEmpty()) {
            throw new DgsEntityNotFoundException(
                    String.format("Customer UUID %s not found", addSalesOrderInput.getCustomerUuid())
            );
        }

        var salesOrderEntity = SalesOrderMapper.mapToEntity(addSalesOrderInput);
        salesOrderEntity.setCustomer(existingCustomer.get());

        return salesOrderRepository.save(salesOrderEntity);
    }

}
