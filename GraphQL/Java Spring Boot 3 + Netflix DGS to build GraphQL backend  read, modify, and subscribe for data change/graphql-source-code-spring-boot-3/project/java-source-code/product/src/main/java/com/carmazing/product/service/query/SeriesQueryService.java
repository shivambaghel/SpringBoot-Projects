package com.carmazing.product.service.query;

import com.carmazing.product.datasource.entity.Series;
import com.carmazing.product.datasource.repository.SeriesRepository;
import com.carmazing.product.datasource.specification.SeriesSpecification;
import com.carmazing.product.generated.types.ManufacturerInput;
import com.carmazing.product.generated.types.SeriesInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesQueryService {

    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> findSeries(Optional<SeriesInput> input) {
        var seriesInput = input.orElse(new SeriesInput());
        var manufacturerInput = seriesInput.getManufacturer() == null ?
                new ManufacturerInput() : seriesInput.getManufacturer();
        var specification = Specification.where(
                StringUtils.isNotBlank(seriesInput.getName()) ?
                        SeriesSpecification.seriesNameContainsIgnoreCase(
                                seriesInput.getName())
                        : null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getName()) ?
                        SeriesSpecification.manufacturerNameContainsIgnoreCase(
                                manufacturerInput.getName())
                        : null
        ).and(
                StringUtils.isNotBlank(manufacturerInput.getOriginCountry()) ?
                        SeriesSpecification.manufacturerOriginCountryContainsIgnoreCase(
                                manufacturerInput.getOriginCountry())
                        : null
        );

        var sortOrders = SeriesSpecification.sortOrdersFrom(
                seriesInput.getSorts()
        );

        return seriesRepository.findAll(specification, Sort.by(sortOrders));
    }

}
