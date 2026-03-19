package org.example.logitrack.controller;

import org.example.logitrack.entity.Commande;
import org.example.logitrack.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/commandes")

public class CommandeController {
    @Autowired
     private CommandeService commandeService;
    @Autowired
    private HandlerMapping resourceHandlerMapping;

    @PostMapping
    public ResponseEntity<Commande> ajouterCommande(
            @RequestParam LocalDate dateCommande,
            @RequestParam String statut,
            @RequestParam Long idClient


            ){
        Commande commande=new Commande();
        commande.setDateCommande(dateCommande);
        commande.setStatut(statut);

        return ResponseEntity.ok(commandeService.ajouterCommande(commande,idClient));


    }
    @GetMapping
    public List<Commande>afficherCommandes(){
        return commandeService.afficherCommandes();
    }
    @GetMapping(("/{id}"))
    public Commande consulterCommande(@PathVariable long id){

        return commandeService.consulterCommande(id);
    }
    @PutMapping("{id}/edit")
    public ResponseEntity<Commande> modifierStatut(
            @PathVariable long id,
            @RequestParam String statut
    ){
        Commande commande=commandeService.modifierStatutCommande(id,statut);
        return ResponseEntity.ok(commande);




    }
    @PostMapping("/{orderId}/products")
    public ResponseEntity<String>ajouterProduitCommande(
            @PathVariable long orderId,
            @RequestParam long idProduit,
            @RequestParam int quantite

    ){
        boolean reponse= commandeService.ajouterProduitCommande(idProduit,orderId,quantite);
        if(!reponse){
            return ResponseEntity.status(404)
                    .body("Erreur");
        }
        return ResponseEntity.status(200).body("produit a été ajouté avec succés");

    }


}
