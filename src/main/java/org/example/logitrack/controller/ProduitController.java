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
@RequestMapping("api/products")

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
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Produit>>getProduitsByCategorie(@PathVariable String categorie){
        List<Produit>produits=produitService.getProduitsByCategorie(categorie);
        return ResponseEntity.ok(produits);
    }
    @GetMapping("price/{price}")
    public ResponseEntity<List<Produit>>getProduitsByPrixInferieur(@PathVariable Double price){
        List<Produit>produits=produitService.getProduitsByPrixInferieur(price);
        return ResponseEntity.ok(produits);
    }
    @GetMapping("/topProduct")
    public ResponseEntity<Produit>getTopProduit(){
        Produit topProduit=produitService.getTopProduct();
        if(topProduit ==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topProduit);
    }


}
