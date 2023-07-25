package uz.muhandis.emailservcie.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.muhandis.emailservcie.dto.OrderEvent;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.email.name}"})
    public void consume(OrderEvent event) {
        LOGGER.info(String.format("Received order event in email service -> %s", event.toString()));
        //save order event data in a database
    }
}
