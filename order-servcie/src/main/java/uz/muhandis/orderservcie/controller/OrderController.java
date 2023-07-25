package uz.muhandis.orderservcie.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.muhandis.orderservcie.dto.Order;
import uz.muhandis.orderservcie.dto.OrderEvent;
import uz.muhandis.orderservcie.publisher.OrderProducer;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }


    @PostMapping("orders")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order is in a pending status");
        event.setOrder(order);
    orderProducer.sendMessage(event);
        return "Order send to the RabbitMQ...";
    }
}
