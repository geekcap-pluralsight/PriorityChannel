package com.pluralsight.globomantics.springintegration.service;

import com.pluralsight.globomantics.springintegration.config.CustomizedPriorityChannelGateway;
import com.pluralsight.globomantics.springintegration.config.PriorityChannelGateway;
import com.pluralsight.globomantics.springintegration.model.Swag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private PriorityChannelGateway swagGateway;

    @Autowired
    private CustomizedPriorityChannelGateway customizedPriorityChannelGateway;

    @Override
    public void commit(String userId) {
        // Send several swag packages
        swagGateway.sendSwag(buildMessage(new Swag("T-Shirt", 5), 1));
        swagGateway.sendSwag(buildMessage(new Swag("Keychain", 2), 7));
        swagGateway.sendSwag(buildMessage(new Swag("Hat", 5), 1));
        swagGateway.sendSwag(buildMessage(new Swag("USB Drive", 10), 8));
        swagGateway.sendSwag(buildMessage(new Swag("Golden Ticket", 1000), 10));
        logger.info("Published five Swag items to the Swag priorityChannel");
    }

    @Override
    public void commitCustomized(String userId) {
        // Send several swag packages
        customizedPriorityChannelGateway.sendSwag(buildMessage(new Swag("T-Shirt", 5), 1));
        customizedPriorityChannelGateway.sendSwag(buildMessage(new Swag("Keychain",2 ), 7));
        customizedPriorityChannelGateway.sendSwag(buildMessage(new Swag("Hat", 5), 1));
        customizedPriorityChannelGateway.sendSwag(buildMessage(new Swag("USB Drive", 10), 8));
        customizedPriorityChannelGateway.sendSwag(buildMessage(new Swag("Golden Ticket", 1000), 10));
        logger.info("Published five Swag items to the customized Swag priorityChannel");
    }

    private Message<Swag> buildMessage(Swag swag, Integer priority) {
        return MessageBuilder.withPayload(swag)
                .setHeader(IntegrationMessageHeaderAccessor.PRIORITY, priority)
                .build();
    }
}
