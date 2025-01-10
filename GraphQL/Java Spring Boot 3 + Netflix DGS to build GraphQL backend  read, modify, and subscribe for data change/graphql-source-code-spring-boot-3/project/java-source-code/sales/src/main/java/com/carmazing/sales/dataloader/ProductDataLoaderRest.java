package com.carmazing.sales.dataloader;

import com.carmazing.sales.constant.DataLoaderConstants;
import com.carmazing.sales.generated.types.SimpleModel;
import com.carmazing.sales.service.query.ProductQueryService;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

@DgsDataLoader(name = "productDataLoaderRest")
public class ProductDataLoaderRest implements
        MappedBatchLoader<String, SimpleModel> {

    @Autowired
    private ProductQueryService productQueryService;

    @Autowired
    @Qualifier(DataLoaderConstants.THREAD_POOL_EXECUTOR_NAME)
    private Executor dataLoaderThreadPoolExecutor;

    @Override
    public CompletionStage<Map<String, SimpleModel>> load(Set<String> keys) {
        return CompletableFuture.supplyAsync(
                () -> productQueryService.loadSimpleModelsRest(keys),
                dataLoaderThreadPoolExecutor
        );
    }
}
