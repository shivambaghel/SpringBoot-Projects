package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.Customer;
import com.carmazing.sales.generated.types.AddCustomerInput;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Optional;

public class CustomerMapper {

    public static Customer mapToEntity(AddCustomerInput original) {
        var mapped = new Customer();

        mapped.setBirthDate(original.getBirthDate());
        mapped.setEmail(original.getEmail());
        mapped.setFullName(original.getFullName());
        mapped.setPhone(original.getPhone());

        if (!CollectionUtils.isEmpty(original.getAddresses())) {
            var addressesEntity = original.getAddresses()
                    .stream().map(AddressMapper::mapToEntity).toList();

            mapped.setAddresses(addressesEntity);
        }

        return mapped;
    }

    public static com.carmazing.sales.generated.types.Customer mapToGraphqlEntity(Customer original) {
        var mapped = new com.carmazing.sales.generated.types.Customer();
        var mappedAddress = Optional.ofNullable(original.getAddresses())
                .orElse(Collections.emptyList())
                .stream().map(AddressMapper::mapToGraphqlEntity)
                .toList();
        var mappedDocuments = Optional.ofNullable(original.getDocuments())
                .orElse(Collections.emptyList())
                .stream().map(DocumentMapper::mapToGraphqlEntity)
                .toList();
        var mappedSalesOrders = Optional.ofNullable(original.getSalesOrders())
                .orElse(Collections.emptyList())
                .stream().map(SalesOrderMapper::mapToGraphqlEntity)
                .toList();

        mapped.setAddresses(mappedAddress);
        mapped.setDocuments(mappedDocuments);
        mapped.setSalesOrders(mappedSalesOrders);
        mapped.setUuid(original.getUuid().toString());
        mapped.setEmail(original.getEmail());
        mapped.setPhone(original.getPhone());
        mapped.setFullName(original.getFullName());
        mapped.setBirthDate(original.getBirthDate());

        return mapped;
    }

}
