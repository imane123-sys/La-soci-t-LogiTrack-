package org.example.logitrack.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeRequestDTO {
    private Long id;
    private int quantite;
    private Long produitId;
}