package org.example.logitrack.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "produit")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String categorie;
    private double prix;

    @Column(name = "quantite")
    private int quantiteStock;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<LigneCommande> lignesCommande;
}