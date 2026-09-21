package com.java.learning.orders.service;

import com.java.learning.common.dto.OrderRequestDto;
import com.java.learning.common.event.OrderEvent;
import com.java.learning.common.event.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {

    @Autowired
    private Sinks.Many<OrderEvent> orderSinks;   // sink is React webflux feature to emit events

    // tryEmitNext() -> emits the event to the subscribers
    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus){
        OrderEvent orderEvent=new OrderEvent(orderRequestDto,orderStatus);
        orderSinks.tryEmitNext(orderEvent);
    }
}
