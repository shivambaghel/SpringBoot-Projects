package com.carmazing.sales.resolver;

import com.carmazing.sales.generated.DgsConstants;
import com.carmazing.sales.generated.types.*;
import com.carmazing.sales.mapper.CustomerMapper;
import com.carmazing.sales.service.command.CustomerCommandService;
import com.carmazing.sales.service.query.CustomerQueryService;
import com.carmazing.sales.service.query.ProductQueryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@DgsComponent
public class CustomerResolver {

    @Autowired
    private CustomerCommandService customerCommandService;

    @Autowired
    private CustomerQueryService customerQueryService;

    @Autowired
    private ProductQueryService productQueryService;

    @DgsMutation
    public CustomerMutationResponse addNewCustomer(
            @InputArgument AddCustomerInput customer
    ) {
        var saved = customerCommandService.addNewCustomer(customer);

        return CustomerMutationResponse.newBuilder()
                .customerUuid(saved.getUuid().toString())
                .success(true)
                .message(String.format("Customer %s saved", customer.getFullName()))
                .build();
    }

    @DgsMutation
    public CustomerMutationResponse addAddressesToExistingCustomer(
            @InputArgument UniqueCustomerInput customer,
            @InputArgument List<AddAddressInput> addresses
    ) {
        var existingCustomer = customerQueryService.findUniqueCustomer(customer);

        if (existingCustomer.isEmpty()) {
            throw new DgsEntityNotFoundException(
                    String.format("Customer: uuid %s / email %s not found",
                            customer.getUuid(), customer.getEmail()
                    )
            );
        }

        customerCommandService.addAddressesToExistingCustomer(
                existingCustomer.get(), addresses
        );

        return CustomerMutationResponse.newBuilder()
                .customerUuid(existingCustomer.get().getUuid().toString())
                .success(true)
                .message(
                        String.format("Added %d addresses to customer", addresses.size())
                )
                .build();
    }

    @DgsQuery
    public CustomerPagination customerPagination(
            @InputArgument Optional<UniqueCustomerInput> customer,
            DataFetchingEnvironment env,
            @InputArgument Integer page,
            @InputArgument Integer size
    ) {
        var pageCustomer = customerQueryService.findCustomers(
                customer, page, size
        );

        var listCustomerAsEntity = Optional.ofNullable(pageCustomer.getContent())
                .orElse(Collections.emptyList());
        var listCustomerAsGraphql = listCustomerAsEntity.stream()
                .map(CustomerMapper::mapToGraphqlEntity).toList();

        // load product detail
//        var allSalesOrderItemsAsGraphql = listCustomerAsGraphql.stream()
//                .flatMap(c -> c.getSalesOrders().stream())
//                .flatMap(so -> so.getSalesOrderItems().stream())
//                .toList();
//
//        for (var salesOrderItem : allSalesOrderItemsAsGraphql) {
//            var simpleModel = productQueryService.loadSimpleModels(
//                    Set.of(salesOrderItem.getModelUuid().toString())
//            );
//            salesOrderItem.setModelDetail(
//                    simpleModel.get(salesOrderItem.getModelUuid())
//            );
//        }

        var pageConnection = new SimpleListConnection<>(
                listCustomerAsGraphql
        ).get(env);

        var paginatedResult = new CustomerPagination();

        paginatedResult.setCustomerConnection(pageConnection);
        paginatedResult.setPage(pageCustomer.getNumber());
        paginatedResult.setSize(pageCustomer.getSize());
        paginatedResult.setTotalElement(pageCustomer.getTotalElements());
        paginatedResult.setTotalPage(pageCustomer.getTotalPages());

        return paginatedResult;
    }

    @DgsMutation
    public CustomerMutationResponse addDocumentToExistingCustomer(
            @InputArgument UniqueCustomerInput customer,
            @InputArgument String documentType,
            DataFetchingEnvironment env
    ) {
        var existingCustomer = customerQueryService.findUniqueCustomer(customer);

        if (existingCustomer.isEmpty()) {
            throw new DgsEntityNotFoundException(
                    String.format("Customer: uuid %s / email %s not found",
                            customer.getUuid(), customer.getEmail()
                    )
            );
        }

        MultipartFile documentFile = env.getArgument(
                DgsConstants.MUTATION.ADDDOCUMENTTOEXISTINGCUSTOMER_INPUT_ARGUMENT.DocumentFile
        );

        customerCommandService.addDocumentToExistingCustomer(
                existingCustomer.get(), documentType, documentFile
        );

        return CustomerMutationResponse.newBuilder()
                .customerUuid(existingCustomer.get().getUuid().toString())
                .success(true)
                .message(
                        documentFile.getOriginalFilename() + " uploaded"
                )
                .build();
    }

    @DgsMutation
    public CustomerMutationResponse updateExistingCustomer(
            @InputArgument UniqueCustomerInput customer,
            @InputArgument UpdateCustomerInput customerUpdate
    ) {
        if (StringUtils.isAllBlank(
                customerUpdate.getEmail(), customerUpdate.getPhone()
        )) {
            throw new IllegalArgumentException("Customer update must not empty");
        }

        var existingCustomer = customerQueryService.findUniqueCustomer(customer);

        if (existingCustomer.isEmpty()) {
            throw new DgsEntityNotFoundException(
                    String.format("Customer: uuid %s / email %s not found",
                            customer.getUuid(), customer.getEmail()
                    )
            );
        }

        customerCommandService.updateCustomer(existingCustomer.get(), customerUpdate);

        return CustomerMutationResponse.newBuilder()
                .customerUuid(existingCustomer.get().getUuid().toString())
                .success(true)
                .message("Customer updated")
                .build();
    }

}
