package org.example.logitrack.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeResponseDTO {
    private Long id;
    private LocalDate dateCommande;
    private String statut;
    private ClientDTO client;
    private List<LigneCommandeResponseDTO> lignesCommande;
}