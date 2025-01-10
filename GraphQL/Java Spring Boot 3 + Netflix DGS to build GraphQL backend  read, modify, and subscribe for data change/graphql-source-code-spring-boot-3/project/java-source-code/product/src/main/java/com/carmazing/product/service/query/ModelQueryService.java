package com.carmazing.product.service.query;

import com.carmazing.product.datasource.entity.Model;
import com.carmazing.product.datasource.repository.ModelRepository;
import com.carmazing.product.datasource.specification.ModelSpecification;
import com.carmazing.product.generated.types.*;
import com.carmazing.product.mapper.ModelMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModelQueryService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> findModels(Optional<ModelInput> input,
                                  Optional<NumericComparisonInput> priceInput) {
        var modelInput = input.orElse(new ModelInput());
        var seriesInput = modelInput.getSeries() == null ? new SeriesInput()
                : modelInput.getSeries();
        var manufacturerInput = seriesInput.getManufacturer() == null ?
                new ManufacturerInput() : seriesInput.getManufacturer();

        var priceSpecification = priceSpecificationFrom(priceInput);

        var specification = Specification.where(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        ModelSpecification.manufacturerNameContainsIgnoreCase(
                                manufacturerInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        ModelSpecification.manufacturerOriginCountryContainsIgnoreCase(
                                manufacturerInput.getOriginCountry()
                        ) : null
        ).and(
                StringUtils.isNotBlank(seriesInput.getName()) ?
                        ModelSpecification.seriesNameContainsIgnoreCase(
                                seriesInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(modelInput.getName()) ?
                        ModelSpecification.modelNameContainsIgnoreCase(
                                modelInput.getName()
                        ) : null
        ).and(
                modelInput.getIsAvailable() != null ?
                        ModelSpecification.available(modelInput.getIsAvailable())
                        : null
        ).and(
                modelInput.getTransmission() != null ?
                        ModelSpecification.transmissionEquals(modelInput.getTransmission())
                        : null
        ).and(
                !CollectionUtils.isEmpty(modelInput.getExteriorColors()) ?
                        ModelSpecification.exteriorColorsLikeIgnoreCase(modelInput.getExteriorColors())
                        : null
        ).and(priceSpecification);

        var sortOrders = ModelSpecification.sortOrdersFrom(
                modelInput.getSorts()
        );

        return modelRepository.findAll(specification, Sort.by(sortOrders));
    }

    private Specification<Model> priceSpecificationFrom(Optional<NumericComparisonInput> priceInput) {
        if (priceInput.isEmpty()) {
            return null;
        }

        var numericComparison = priceInput.get().getOperator();
        var value = priceInput.get().getValue();

        return switch (numericComparison) {
            case GREATER_THAN_EQUALS:
                yield ModelSpecification.priceGreaterThanEquals(value);
            case LESS_THAN_EQUALS:
                yield ModelSpecification.priceLessThanEquals(value);
            case BETWEEN_INCLUSIVE:
                var highValue = priceInput.get().getHighValue() > value ?
                        priceInput.get().getHighValue() : value + 1;
                yield ModelSpecification.priceBetween(value, highValue);
        };
    }

    public Page<Model> findModels(Optional<ModelInput> input,
                                  Optional<NumericComparisonInput> priceInput,
                                  Integer page,
                                  Integer size) {
        var modelInput = input.orElse(new ModelInput());
        var seriesInput = modelInput.getSeries() == null ? new SeriesInput()
                : modelInput.getSeries();
        var manufacturerInput = seriesInput.getManufacturer() == null ?
                new ManufacturerInput() : seriesInput.getManufacturer();

        var priceSpecification = priceSpecificationFrom(priceInput);

        var specification = Specification.where(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        ModelSpecification.manufacturerNameContainsIgnoreCase(
                                manufacturerInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        ModelSpecification.manufacturerOriginCountryContainsIgnoreCase(
                                manufacturerInput.getOriginCountry()
                        ) : null
        ).and(
                StringUtils.isNotBlank(seriesInput.getName()) ?
                        ModelSpecification.seriesNameContainsIgnoreCase(
                                seriesInput.getName()
                        ) : null
        ).and(
                StringUtils.isNotBlank(modelInput.getName()) ?
                        ModelSpecification.modelNameContainsIgnoreCase(
                                modelInput.getName()
                        ) : null
        ).and(
                modelInput.getIsAvailable() != null ?
                        ModelSpecification.available(modelInput.getIsAvailable())
                        : null
        ).and(
                modelInput.getTransmission() != null ?
                        ModelSpecification.transmissionEquals(modelInput.getTransmission())
                        : null
        ).and(
                !CollectionUtils.isEmpty(modelInput.getExteriorColors()) ?
                        ModelSpecification.exteriorColorsLikeIgnoreCase(modelInput.getExteriorColors())
                        : null
        ).and(priceSpecification);

        var sortOrders = ModelSpecification.sortOrdersFrom(
                modelInput.getSorts()
        );

        var pageable = PageRequest.of(
                Optional.ofNullable(page).orElse(0),
                Optional.ofNullable(size).orElse(50),
                Sort.by(sortOrders)
        );

        return modelRepository.findAll(specification, pageable);
    }

    public List<ModelSimple> findModels(List<String> modelUuids) {
        var models = modelRepository.findAllById(
                modelUuids.stream().map(UUID::fromString).toList()
        );

        return models.stream().map(ModelMapper::toModelSimple).toList();
    }

}
