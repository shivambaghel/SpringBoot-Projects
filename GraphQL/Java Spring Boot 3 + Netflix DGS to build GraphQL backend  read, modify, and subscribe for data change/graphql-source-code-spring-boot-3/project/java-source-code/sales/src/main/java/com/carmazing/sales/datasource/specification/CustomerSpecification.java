package com.carmazing.sales.datasource.specification;

import com.carmazing.sales.datasource.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class CustomerSpecification extends BaseSpecification {

    public static final String FIELD_UUID = "uuid";
    public static final String FIELD_EMAIL = "email";

    public static Specification<Customer> uuidEqualsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get(FIELD_UUID),
                        UUID.fromString(keyword.toLowerCase())
                );
    }

    public static Specification<Customer> emailEqualsIgnoreCase(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get(FIELD_EMAIL)),
                        keyword.toLowerCase()
                );
    }

}
