package com.carmazing.product.mapper;

import com.carmazing.product.datasource.entity.Model;
import com.carmazing.product.generated.types.BodyType;
import com.carmazing.product.generated.types.Fuel;
import com.carmazing.product.generated.types.ModelSimple;
import com.carmazing.product.generated.types.Transmission;
import org.apache.commons.lang3.StringUtils;

public class ModelMapper {

    public static ModelSimple toModelSimple(Model original) {
        var mapped = new ModelSimple();

        mapped.setBodyType(
                BodyType.valueOf(StringUtils.upperCase(original.getBodyType()))
        );
        mapped.setFuel(
                Fuel.valueOf(StringUtils.upperCase(original.getFuel()))
        );
        mapped.setTransmission(
                Transmission.valueOf(StringUtils.upperCase(original.getTransmission()))
        );
        mapped.setName(original.getName());
        mapped.setUuid(original.getUuid().toString());
        mapped.setOnTheRoadPrice(original.getOnTheRoadPrice());
        mapped.setExteriorColor(original.getExteriorColor());
        mapped.setInteriorColor(original.getInteriorColor());
        mapped.setReleaseYear(original.getReleaseYear());

        return mapped;
    }

}
