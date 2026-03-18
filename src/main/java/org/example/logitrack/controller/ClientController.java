package org.example.logitrack.controller;

import org.example.logitrack.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Client> listeClients(){
        return clientService.afficherClients();

    }
    @GetMapping("/{id}")
    public Client consulterClient(@PathVariable long id){
        return clientService.ConsulterClient(id);
    }
    @PostMapping
    public ResponseEntity<Client>ajouterClient(
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam  String ville
    ) {
        Client client = new Client();
        client.setNom(nom);
        client.setEmail(email);
        client.setTelephone(telephone);
        client.setVille(ville);
       return ResponseEntity.ok(clientService.ajouterClient(client));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>supprimerClient(@PathVariable long id){
        clientService.SupprimerClient(id);
        return ResponseEntity.ok().build();//ou bien objet



    }



}
