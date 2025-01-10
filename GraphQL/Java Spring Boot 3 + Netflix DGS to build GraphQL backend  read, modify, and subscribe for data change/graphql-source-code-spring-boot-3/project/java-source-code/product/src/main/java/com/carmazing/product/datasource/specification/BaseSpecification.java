package com.carmazing.product.datasource.specification;

import com.carmazing.product.generated.types.SortDirection;
import com.carmazing.product.generated.types.SortInput;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseSpecification {

    protected static String contains(String keyword) {
        return MessageFormat.format("%{0}%", keyword);
    }

    public static List<Sort.Order> sortOrdersFrom(List<SortInput> sortInputs) {
        if (CollectionUtils.isEmpty(sortInputs)) {
            return Collections.emptyList();
        }

        var sortOrders = new ArrayList<Sort.Order>();

        for (var sortInput : sortInputs) {
            var order = sortInput.getDirection().equals(SortDirection.ASCENDING) ?
                    Sort.Order.asc(sortInput.getField()) :
                    Sort.Order.desc(sortInput.getField());
            sortOrders.add(order);
        }

        return sortOrders;
    }

}
