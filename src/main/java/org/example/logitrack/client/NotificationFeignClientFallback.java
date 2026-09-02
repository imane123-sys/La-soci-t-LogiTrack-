package org.example.logitrack.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
abstract class NotificationClientFallback implements NotificationClient {

    @Override
    public void sendNotification(org.example.logitrack.dtos.NotificationRequestDto dto) {
        log.error("[FALLBACK] Le Notification Service est actuellement indisponible. " +
                        "La notification n'a pas pu être envoyée. Commande ID: {}, Type: {}",
                dto.getOrderId(), dto.getType());

    }
}