package org.example.logitrack.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String telephone;
    private String ville;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;
}