package org.example.logitrack.service;

import org.example.logitrack.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.logitrack.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired

    private ClientRepository clientRepository;

    public Client ajouterClient(Client client){
      return  clientRepository.save(client);

    }
    public List<Client>afficherClients(){
        return clientRepository.findAll();


    }
    public Client ConsulterClient(long id){
        return clientRepository.findById(id).get();
    }
    public void SupprimerClient(long id){
         clientRepository.deleteById(id);
    }
}
