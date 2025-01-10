package com.carmazing.sales.config;

import com.carmazing.sales.constant.DataLoaderConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class DataLoaderConfig {

    @Bean(name = DataLoaderConstants.THREAD_POOL_EXECUTOR_NAME)
    Executor dataLoaderThreadPoolExecutor() {
        return Executors.newCachedThreadPool();
    }

}
