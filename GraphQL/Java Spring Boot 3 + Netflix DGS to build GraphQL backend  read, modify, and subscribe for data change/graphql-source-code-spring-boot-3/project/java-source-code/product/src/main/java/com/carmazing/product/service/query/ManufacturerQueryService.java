package com.carmazing.product.service.query;

import com.carmazing.product.datasource.entity.Manufacturer;
import com.carmazing.product.datasource.repository.ManufacturerRepository;
import com.carmazing.product.datasource.specification.ManufacturerSpecification;
import com.carmazing.product.generated.types.ManufacturerInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerQueryService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findManufacturers(Optional<ManufacturerInput> input) {
        var manufacturerInput = input.orElse(new ManufacturerInput());
        var specification = Specification.where(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        ManufacturerSpecification.nameContainsIgnoreCase(manufacturerInput.getName()) :
                        null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        ManufacturerSpecification.originCountryContainsIgnoreCase(manufacturerInput.getOriginCountry()) :
                        null
        );

        var sortOrders = ManufacturerSpecification.sortOrdersFrom(
                manufacturerInput.getSorts()
        );

        return manufacturerRepository.findAll(specification, Sort.by(sortOrders));
    }

}
