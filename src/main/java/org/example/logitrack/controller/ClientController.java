package org.example.logitrack.controller;

import org.example.logitrack.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client_request) {
        Client client = new Client();
        client.setNom(client_request.getNom());
        client.setPrenom(client_request.getPrenom());
        client.setEmail(client_request.getEmail());
        client.setTelephone(client_request.getTelephone());
        client.setVille(client_request.getVille());
        return ResponseEntity.ok(clientService.ajouterClient(client));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Client> modifierClient(
            @PathVariable long id,
            @RequestBody Client clientRequest
    ) {
        return ResponseEntity.ok(clientService.modifierClient(id, clientRequest));
    }

    @GetMapping("/getClientsNom/{nom}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public ResponseEntity<List<Client>> getClientsNom(@PathVariable String nom){
        return ResponseEntity.ok(clientService.getClientsNom(nom));
    }
    @GetMapping("/clientsPagines")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    public ResponseEntity<Page<Client>> getAllClients(Pageable pageable) {

        return ResponseEntity.ok(
                clientService.getAllClients(pageable));
    }

}
