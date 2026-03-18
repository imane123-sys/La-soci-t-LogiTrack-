package org.example.logitrack.repository;

import org.example.logitrack.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository  extends JpaRepository<Produit,Long> {
}
