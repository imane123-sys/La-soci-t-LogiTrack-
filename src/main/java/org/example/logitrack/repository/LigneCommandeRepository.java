package org.example.logitrack.repository;

import org.example.logitrack.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
    @Query ("SELECT COUNT(lc) FROM LigneCommande lc WHERE lc.commande.client.id =:idClient")
    long CountLignesCommandesClient(@Param("idClient")int idClient);
}
