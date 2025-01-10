package com.carmazing.sales.service.query;

import com.carmazing.sales.datasource.entity.Customer;
import com.carmazing.sales.datasource.repository.CustomerRepository;
import com.carmazing.sales.datasource.specification.CustomerSpecification;
import com.carmazing.sales.generated.types.UniqueCustomerInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerQueryService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findUniqueCustomer(UniqueCustomerInput uniqueCustomerInput) {
        var customerUuid = uniqueCustomerInput.getUuid();
        var customerEmail = uniqueCustomerInput.getEmail();

        if (StringUtils.isNoneBlank(customerUuid, customerEmail)) {
            throw new IllegalArgumentException("Only one parameter (customer UUID" +
                    "OR customer email) allowed, not both");
        } else if (StringUtils.isAllBlank(customerUuid, customerEmail)) {
            throw new IllegalArgumentException("One of customer UUID OR customer" +
                    " email must exists");
        }

        var specification = StringUtils.isNotBlank(customerUuid) ?
                Specification.where(CustomerSpecification.uuidEqualsIgnoreCase(customerUuid)) :
                Specification.where(CustomerSpecification.emailEqualsIgnoreCase(customerEmail));

        return customerRepository.findOne(specification);
    }

    public Page<Customer> findCustomers(
            Optional<UniqueCustomerInput> customer,
            Integer page, Integer size) {
        var pageable = PageRequest.of(
                Optional.ofNullable(page).orElse(0),
                Optional.ofNullable(size).orElse(50),
                Sort.by(CustomerSpecification.FIELD_EMAIL)
        );

        if (customer.isPresent()) {
            var existingCustomer = findUniqueCustomer(customer.get());

            return existingCustomer.isPresent() ?
                    new PageImpl<Customer>(
                            List.of(existingCustomer.get()), pageable, 1
                    ) :
                    new PageImpl<Customer>(
                            Collections.emptyList(), pageable, 0
                    );
        }

        return customerRepository.findAll(pageable);
    }

}
