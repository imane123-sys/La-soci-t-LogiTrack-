package org.example.logitrack.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDTO {
    private Long id;
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
}
