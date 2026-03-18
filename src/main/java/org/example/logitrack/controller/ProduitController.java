package org.example.logitrack.controller;

import org.example.logitrack.entity.Client;
import org.example.logitrack.entity.Produit;
import org.example.logitrack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.logitrack.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("api/produits")

public class ProduitController {
    @Autowired
   private  ProduitService produitService;


    @GetMapping
    public List<Produit> listeProduits(){
        return produitService.afficherListeProduit();

    }
    @GetMapping("/{id}")
    public Produit consulterProduit(@PathVariable long id){
        return produitService.consulterProduit(id);
    }
    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(
            @RequestParam String nom,
            @RequestParam String categorie,
            @RequestParam double prix,
            @RequestParam  int quantiteStock
    ) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setCategorie(categorie);
        produit.setPrix(prix);
        produit.setQuantiteStock(quantiteStock);
        return ResponseEntity.ok(produitService.ajouterProduit(produit));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        produitService.supprimerProduit(id);
        return ResponseEntity.ok().build();//ou bien objet



    }


}
