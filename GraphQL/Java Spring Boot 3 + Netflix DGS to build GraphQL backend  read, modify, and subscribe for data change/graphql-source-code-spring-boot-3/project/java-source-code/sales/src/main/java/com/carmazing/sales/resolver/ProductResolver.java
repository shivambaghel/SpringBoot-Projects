package com.carmazing.sales.resolver;

import com.carmazing.sales.dataloader.ProductDataLoader;
import com.carmazing.sales.dataloader.ProductDataLoaderRest;
import com.carmazing.sales.generated.DgsConstants;
import com.carmazing.sales.generated.types.SalesOrderItem;
import com.carmazing.sales.generated.types.SimpleModel;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

@DgsComponent
public class ProductResolver {

    @DgsData(
            parentType = DgsConstants.SALESORDERITEM.TYPE_NAME,
            field = DgsConstants.SALESORDERITEM.ModelDetail
    )
    public CompletableFuture<SimpleModel> loadSimpleModels(DgsDataFetchingEnvironment env) {
//        DataLoader<String, SimpleModel> productDataLoader = env.getDataLoader(ProductDataLoader.class);
        DataLoader<String, SimpleModel> productDataLoader = env.getDataLoader(
                ProductDataLoaderRest.class
        );
        SalesOrderItem salesOrderItem = env.getSource();

        return productDataLoader.load(salesOrderItem.getModelUuid());
    }

}
