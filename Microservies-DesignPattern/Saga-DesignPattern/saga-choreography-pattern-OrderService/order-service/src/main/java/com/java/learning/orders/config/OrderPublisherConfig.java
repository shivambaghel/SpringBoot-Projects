package com.java.learning.orders.config;

import com.java.learning.common.event.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class OrderPublisherConfig {

    // as we are using OrderService -> orderStatusPublisher.publishOrderEvent to publish the events ,
    // in order to publish the event using kafka, we are utilizing this configuration class.


    // Sinks is a reactive stream that emits events to the subscribers.
    @Bean
    public Sinks.Many<OrderEvent> orderSinks(){
        return Sinks.many().multicast().onBackpressureBuffer(); // many() -> emits events to all subscribers
    }

    // Supplier is a function that returns a value.
    @Bean
    public Supplier<Flux<OrderEvent>> orderSupplier(Sinks.Many<OrderEvent> sinks){
        return sinks::asFlux;   // asFlux() -> emits events to the subscribers
    }


    // now refer application.yaml file for cloud config
}
