package org.example.logitrack.service;

import org.example.logitrack.entity.Produit;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    public List<Produit> afficherListeProduit(){
        return produitRepository.findAll();
    }
    public Produit consulterProduit(long id){
        return produitRepository.findById(id).get();
    }
    public void supprimerProduit(long id){
         produitRepository.deleteById(id);
    }
    public Produit ajouterProduit(Produit p){
        return produitRepository.save(p);

    }
    public List<Produit>getProduitsByCategorie(String categorie){
        return produitRepository.findByCategorie(categorie);

    }
    public List<Produit>getProduitsByPrixInferieur(Double prix){
        return produitRepository.findByPrixLessThan(prix);
    }
    public Produit getTopProduct(){
        return produitRepository.findTopProduit();

    }
}
