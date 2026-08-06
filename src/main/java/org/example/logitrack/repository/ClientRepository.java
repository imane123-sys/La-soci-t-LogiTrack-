package org.example.logitrack.repository;

import org.example.logitrack.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE " +
            "(:nom IS NULL OR :nom = '' OR LOWER(c.nom) LIKE LOWER(CONCAT('%', :nom, '%')))")
    Page<Client> searchClients(@Param("nom") String nom, Pageable pageable);
}
