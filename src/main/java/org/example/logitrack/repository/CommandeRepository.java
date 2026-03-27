package org.example.logitrack.repository;

import org.example.logitrack.entity.Commande;
import org.example.logitrack.service.LigneCommandeService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande>findByClientId(Long ClientId);
}
