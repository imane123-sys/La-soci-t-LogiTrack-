package org.example.logitrack.repository;

import org.example.logitrack.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProduitRepository  extends JpaRepository<Produit,Long> {
    List<Produit> findByCategorie(String categorie);
    List<Produit>findByPrixLessThan(Double prix);
    @Query("SELECT lc.produit FROM LigneCommande lc GROUP BY lc.produit ORDER BY SUM(lc.quantite) DESC LIMIT 1")
    Produit findTopProduit();
}
