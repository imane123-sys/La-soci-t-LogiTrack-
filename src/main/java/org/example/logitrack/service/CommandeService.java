package org.example.logitrack.service;

import org.example.logitrack.entity.Commande;
import org.example.logitrack.entity.LigneCommande;
import org.example.logitrack.entity.Produit;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public Commande ajouterCommande(Commande commande){
        return commandeRepository.save(commande);
    }
    public List<Commande> afficherCommandes(){
        return commandeRepository.findAll();
                
    }
    public Commande consulterCommande(long id){
        return commandeRepository.findById(id).get();
    }

    //
//    public LigneCommande addProduitToOrder(Long idCommande , Long idProdutt , int quantite){
//        Commande commande = commandeRepository.findById(idCommande).orElseThrow();
//        Produit produit = produitRepository.findById(idProdutt).orElseThrow();
//
//        LigneCommande ligneCommande = new LigneCommande();
//        ligneCommande.setCommande(commande);
//        ligneCommande.setProduit(produit);
//        ligneCommande.setQuantite(quantite);
//        ligneCommande.setQuantite(produit.getQuantiteStock() - quantite);
//        produitRepository.save(produit);
//        return ligneCommandeRepository.save(ligneCommande);
//    }
//    public void modifierStatut(){
//
//    }
}
