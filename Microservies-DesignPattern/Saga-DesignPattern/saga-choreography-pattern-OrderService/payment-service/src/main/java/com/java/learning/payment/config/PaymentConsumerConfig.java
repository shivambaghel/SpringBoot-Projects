package com.java.learning.payment.config;

import com.java.learning.common.event.OrderEvent;
import com.java.learning.common.event.OrderStatus;
import com.java.learning.common.event.PaymentEvent;
import com.java.learning.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;


// class will consume orderService events and validate and process payment,
// in case of failure will cancel the order and publish event as failure
@Configuration
public class PaymentConsumerConfig {

    @Autowired
    private PaymentService paymentService;

    // it will act as both (consumer from orderEvent topic and publish to paymentEvent topic)
    @Bean
    public Function<Flux<OrderEvent>, Flux<PaymentEvent>> paymentProcessor() {
        return orderEventFlux -> orderEventFlux.flatMap(this::processPayment);
        // process payment for each order event
    }

    private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
        // get the user id
        // check the balance availability
        // if balance sufficient -> Payment completed and deduct amount from DB
        // if payment not sufficient -> cancel order event and update the amount in DB
        if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())){
            return  Mono.fromSupplier(()->this.paymentService.newOrderEvent(orderEvent)); //
        }else{
            return Mono.fromRunnable(()->this.paymentService.cancelOrderEvent(orderEvent));
        }
    }
}
