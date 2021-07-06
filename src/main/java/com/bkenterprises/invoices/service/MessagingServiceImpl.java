package com.bkenterprises.invoices.service;

import com.bkenterprises.invoices.model.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MessagingServiceImpl implements MessagingService {

    @Value("${cloud.aws.credentials.sqs.endpoint}")
    private String endpoint;

    @Autowired
    SecurityService securityService;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    private final String MESSAGE_GROUP_ID = "message-group-id";

    public void publishInvoice(Invoice invoice) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String output = mapper.writeValueAsString(invoice);
        String messageGroupId = securityService.generateUUID(IdentifierType.MESSAGE_GROUP_ID);
        Message<?> message = MessageBuilder.withPayload(output)
                .setHeader(MESSAGE_GROUP_ID, messageGroupId)
                .build();
        queueMessagingTemplate.send(endpoint, message);
    }

}
