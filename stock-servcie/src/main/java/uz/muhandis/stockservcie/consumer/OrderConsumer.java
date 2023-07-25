package uz.muhandis.stockservcie.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.muhandis.stockservcie.dto.OrderEvent;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.order.name}"})
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Received message -> %s", event.toString()));
        //save order event data in a database
    }
}
