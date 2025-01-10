package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.Address;
import com.carmazing.sales.generated.types.AddAddressInput;

public class AddressMapper {

    public static Address mapToEntity(AddAddressInput original) {
        var mapped = new Address();

        mapped.setStreet(original.getStreet());
        mapped.setCity(original.getCity());
        mapped.setZipcode(original.getZipcode());

        return mapped;
    }

    public static com.carmazing.sales.generated.types.Address mapToGraphqlEntity(Address original) {
        var mapped = new com.carmazing.sales.generated.types.Address();

        mapped.setUuid(original.getUuid().toString());
        mapped.setCity(original.getCity());
        mapped.setStreet(original.getStreet());
        mapped.setZipcode(original.getZipcode());

        return mapped;
    }
}
