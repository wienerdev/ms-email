package com.wienerdev.msemail.consumer;

import com.wienerdev.msemail.dto.EmailDTO;
import com.wienerdev.msemail.model.EmailModel;
import com.wienerdev.msemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        EmailModel email = emailService.sendEmail(emailDTO);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }

}
