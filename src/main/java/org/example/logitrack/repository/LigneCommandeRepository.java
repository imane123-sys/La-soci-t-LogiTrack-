package org.example.logitrack.repository;

import org.example.logitrack.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
