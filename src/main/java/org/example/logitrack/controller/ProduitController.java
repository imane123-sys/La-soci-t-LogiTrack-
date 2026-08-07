package org.example.logitrack.controller;

import org.example.logitrack.entity.Client;
import org.example.logitrack.entity.Produit;
import org.example.logitrack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.example.logitrack.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("api/products")

public class ProduitController {
    @Autowired
   private  ProduitService produitService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public List<Produit> listeProduits(){
        return produitService.afficherListeProduit();

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public Produit consulterProduit(@PathVariable long id){
        return produitService.consulterProduit(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Produit> ajouterProduit(
           @RequestBody Produit produitOBJ

    ) {
        Produit produit = new Produit();
        produit.setNom(produitOBJ.getNom());
        produit.setCategorie(produitOBJ.getCategorie());
        produit.setPrix(produitOBJ.getPrix());
        produit.setQuantiteStock(produitOBJ.getQuantiteStock());
        return ResponseEntity.ok(produitService.ajouterProduit(produit));

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        produitService.supprimerProduit(id);
        return ResponseEntity.ok().build();//ou bien objet



    }

    @GetMapping("/category/{category}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public ResponseEntity<List<Produit>>getProduitsByCategorie(@PathVariable String category){
        List<Produit>produits=produitService.getProduitsByCategorie(category);
        return ResponseEntity.ok(produits);
    }

    @GetMapping("price/{price}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public ResponseEntity<List<Produit>>getProduitsByPrixInferieur(@PathVariable Double price){
        List<Produit>produits=produitService.getProduitsByPrixInferieur(price);
        return ResponseEntity.ok(produits);
    }


    @GetMapping("/topProduct")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Produit>getTopProduit(){
        Produit topProduit=produitService.getTopProduct();
        if(topProduit ==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topProduit);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Produit> modifierProduit(
            @PathVariable long id,
            @RequestBody Produit produitRequest
    ) {
        return ResponseEntity.ok(produitService.modifierProduit(id, produitRequest));
    }
    @GetMapping("/findProduitParPrix/{prix}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER','AGENT')")

    public ResponseEntity<List<Produit>> findByPrix(@PathVariable Double prix){
        return ResponseEntity.ok(produitService.findByPrix(prix));

    }
}
