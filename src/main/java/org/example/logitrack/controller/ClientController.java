package org.example.logitrack.controller;

import org.example.logitrack.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.example.logitrack.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public List<Client> listeClients(){
        return clientService.afficherClients();

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public Client consulterClient(@PathVariable long id){
        return clientService.ConsulterClient(id);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Client>ajouterClient(

            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String telephone,
            @RequestParam  String ville
    ) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTelephone(telephone);
        client.setVille(ville);
       return ResponseEntity.ok(clientService.ajouterClient(client));

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();



    }



}
