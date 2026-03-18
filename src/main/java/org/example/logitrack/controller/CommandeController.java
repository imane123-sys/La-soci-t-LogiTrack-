package org.example.logitrack.controller;

import org.example.logitrack.entity.Commande;
import org.example.logitrack.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/commandes")

public class CommandeController {
    @Autowired
     private CommandeService commandeService;
    @PostMapping
    public ResponseEntity<Commande> ajouterCommande(
            @RequestParam LocalDate dateCommande,
            @RequestParam String statut


            ){
        Commande commande=new Commande();
        commande.setDateCommande(dateCommande);
        commande.setStatut(statut);
        return ResponseEntity.ok(commandeService.ajouterCommande(commande));

    }
    @GetMapping
    public List<Commande>afficherCommandes(){
        return commandeService.afficherCommandes();
    }
    @GetMapping(("/id"))
    public Commande consulterCommande(@PathVariable long id){
        return commandeService.consulterCommande(id);
    }

}
