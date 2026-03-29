package org.example.logitrack.repository;

import org.example.logitrack.entity.Commande;
import org.example.logitrack.service.LigneCommandeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande>findByClientId(Long ClientId);
    @Query("SELECT COUNT(c)FROM Commande c")
     Long countAllOrders();
}
