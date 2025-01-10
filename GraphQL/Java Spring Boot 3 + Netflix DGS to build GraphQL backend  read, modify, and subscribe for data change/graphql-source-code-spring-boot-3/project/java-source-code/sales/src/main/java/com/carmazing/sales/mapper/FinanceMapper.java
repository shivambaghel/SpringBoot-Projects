package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.Finance;
import com.carmazing.sales.generated.types.FinanceInput;

public class FinanceMapper {

    public static Finance mapToEntity(FinanceInput original) {
        var mapped = new Finance();

        mapped.setBaseAmount(original.getBaseAmount());
        mapped.setLoan(original.getIsLoan());
        mapped.setDiscountAmount(original.getDiscountAmount());
        mapped.setTaxAmount(original.getTaxAmount());

        if (original.getLoan() != null) {
            var mappedLoan = LoanMapper.mapToEntity(original.getLoan());

            mappedLoan.setFinance(mapped);
            mapped.setLoan(mappedLoan);
        }

        return mapped;
    }

    public static com.carmazing.sales.generated.types.Finance mapToGraphqlEntity(Finance original) {
        var mapped = new com.carmazing.sales.generated.types.Finance();
        var mappedLoan = original.getLoan() != null ?
                LoanMapper.mapToGraphqlEntity(original.getLoan()) : null;

        mapped.setLoan(mappedLoan);
        mapped.setUuid(original.getUuid().toString());
        mapped.setBaseAmount(original.getBaseAmount());
        mapped.setDiscountAmount(original.getDiscountAmount());
        mapped.setTaxAmount(original.getTaxAmount());
        mapped.setIsLoan(original.isLoan());

        return mapped;
    }

}
