package repository;

import entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;


public interface ProduitRepository  extends JpaRepository<Produit,Long> {
}
