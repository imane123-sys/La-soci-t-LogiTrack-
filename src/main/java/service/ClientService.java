package service;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
@Service
public class ClientService {
    @Autowired

    private ClientRepository clientRepository;

    public void ajouterClient(Client client){
        clientRepository.save(client);

    }
}
