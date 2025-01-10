package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.Loan;
import com.carmazing.sales.generated.types.LoanInput;

public class LoanMapper {

    public static Loan mapToEntity(LoanInput original) {
        var mapped = new Loan();

        mapped.setContactPersonEmail(original.getContactPersonEmail());
        mapped.setContactPersonName(original.getContactPersonName());
        mapped.setContactPersonPhone(original.getContactPersonPhone());
        mapped.setFinanceCompany(original.getFinanceCompany());

        return mapped;
    }

    public static com.carmazing.sales.generated.types.Loan mapToGraphqlEntity(Loan original) {
        var mapped = new com.carmazing.sales.generated.types.Loan();

        mapped.setUuid(original.getUuid().toString());
        mapped.setFinanceCompany(original.getFinanceCompany());
        mapped.setContactPersonEmail(original.getContactPersonEmail());
        mapped.setContactPersonName(original.getContactPersonName());
        mapped.setContactPersonPhone(original.getContactPersonPhone());

        return mapped;
    }

}
