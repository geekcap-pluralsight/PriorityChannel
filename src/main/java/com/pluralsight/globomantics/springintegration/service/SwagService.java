package com.pluralsight.globomantics.springintegration.service;

import com.pluralsight.globomantics.springintegration.model.Swag;
import org.springframework.messaging.Message;

public interface SwagService {
    void sendSwag(Message<Swag> swag);
    void customizedSendSwag(Message<Swag> swag);
}
