package com.carmazing.sales.mapper;

import com.carmazing.sales.datasource.entity.CustomerDocument;

public class DocumentMapper {

    public static com.carmazing.sales.generated.types.Document mapToGraphqlEntity(
            CustomerDocument original) {
        var mapped = new com.carmazing.sales.generated.types.Document();

        mapped.setUuid(original.getUuid().toString());
        mapped.setDocumentPath(original.getDocumentPath());
        mapped.setDocumentType(original.getDocumentType());

        return mapped;
    }
}
