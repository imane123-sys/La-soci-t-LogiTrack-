package org.example.logitrack.service;

import lombok.AllArgsConstructor;
import org.example.logitrack.entity.Client;
import org.example.logitrack.entity.Commande;
import org.example.logitrack.entity.LigneCommande;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LigneCommandeService {
    private LigneCommandeRepository ligneCommandeRepository;
    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande) {


        return ligneCommandeRepository.save(ligneCommande);
    }


}
