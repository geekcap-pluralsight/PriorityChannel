package com.pluralsight.globomantics.springintegration.config;

import com.pluralsight.globomantics.springintegration.model.Swag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Comparator;

@Configuration
@EnableIntegration
public class PriorityChannelConfig {
    @Bean
    public MessageChannel priorityChannel() {
        return new PriorityChannel();
    }

    @Bean
    public MessageChannel customizedPriorityChannel() {
        return new PriorityChannel(Comparator.comparingLong((Message<?> m) -> ((Swag)m.getPayload()).getAmount()).reversed());
    }
}