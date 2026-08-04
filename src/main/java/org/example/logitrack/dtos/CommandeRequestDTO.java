package org.example.logitrack.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeRequestDTO {
    private Long id;
    private LocalDate dateCommande;
    private String statut;
    private Long clientId;
    private List<LigneCommandeRequestDTO> lignesCommande;
}