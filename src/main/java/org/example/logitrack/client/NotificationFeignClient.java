package org.example.logitrack.client;

import org.example.logitrack.dtos.NotificationRequestDto;
import org.example.logitrack.dtos.OrderStatusChangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification-service",
        url = "",
        fallback = NotificationFeignClientFallback.class
)
public interface NotificationFeignClient {

    @PostMapping("/api/notifications")
    void sendNotification(@RequestBody NotificationRequestDto dto);

    @PostMapping("/api/notifications/order-status")
    void notifyStatusChange(@RequestBody OrderStatusChangeDto dto);
}
