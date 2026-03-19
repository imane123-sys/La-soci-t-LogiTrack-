package org.example.logitrack.service;

import org.example.logitrack.entity.Client;
import org.example.logitrack.entity.Commande;
import org.example.logitrack.entity.LigneCommande;
import org.example.logitrack.entity.Produit;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private LigneCommandeService ligneCommandeService;

    public Commande ajouterCommande(Commande commande,long idClient) {
        Client client= clientRepository.findById(idClient)
                .orElseThrow(()-> new RuntimeException("Client non trouvé avec:"+idClient));
        commande.setClient(client);

        return commandeRepository.save(commande);
    }

    public List<Commande> afficherCommandes() {
        return commandeRepository.findAll();

    }

    public Commande consulterCommande(long id) {
        return commandeRepository.findById(id).get();
    }



public boolean ajouterProduitCommande(
        long idProduit,
        long idCommande,
        int quantite

){
       Commande commande= commandeRepository.findById(idCommande).get();
       Produit produit=produitService.consulterProduit(idProduit);


       if(commande == null ||produit ==null || produit.getQuantiteStock()<quantite){
           return false;
       }
       LigneCommande ligneCommande = new LigneCommande();
       ligneCommande.setProduit(produit);
       produit.getLignesCommande().add(ligneCommande);
       commande.getLignesCommande().add(ligneCommande);
       commandeRepository.save(commande);
       produitService.ajouterProduit(produit);
       ligneCommandeService.ajouterLigneCommande(ligneCommande);




       return true;

}
    public Commande modifierStatutCommande( Long id,
             String statut
    ) {
        Commande commande=commandeRepository.findById(id).get();
        commande.setStatut(statut);
        return commandeRepository.save(commande);


    }
}
