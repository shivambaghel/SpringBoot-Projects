package com.carmazing.sales.resolver;

import com.carmazing.sales.generated.DgsConstants;
import com.carmazing.sales.generated.types.Model;
import com.carmazing.sales.service.query.SalesOrderItemQueryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@DgsComponent
public class ModelResolver {

    @Autowired
    private SalesOrderItemQueryService salesOrderItemQueryService;

    @DgsEntityFetcher(name = DgsConstants.MODEL.TYPE_NAME)
    public Model model(Map<String, Object> values) {
        return Model.newBuilder()
                .uuid(
                        values.get(DgsConstants.MODEL.Uuid).toString()
                ).build();
    }

    @DgsData(
            parentType = DgsConstants.MODEL.TYPE_NAME,
            field = DgsConstants.MODEL.SalesPercentage
    )
    public double fetchSalesPercentage(DgsDataFetchingEnvironment env) {
        Model source = env.getSource();
        return salesOrderItemQueryService.findModelSalesPercentage(source.getUuid());
    }

}
