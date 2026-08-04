package org.example.logitrack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeResponseDTO {
    private Long id;
    private int quantite;
    private ProduitDTO produit;
}