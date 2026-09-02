package org.example.logitrack.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.logitrack.enums.NotificationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDto {

    @NotNull(message = "L'ID de la commande est obligatoire")
    private Long orderId;

    @NotBlank(message = "Le message ne peut pas être vide")
    private String message;

    @NotNull(message = "Le type de notification est obligatoire")
    private NotificationType type;
}