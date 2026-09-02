package org.example.logitrack.service;

import lombok.extern.slf4j.Slf4j;
import org.example.logitrack.client.NotificationClient;
import org.example.logitrack.dtos.NotificationRequestDto;
import org.example.logitrack.entity.Client;
import org.example.logitrack.entity.Commande;
import org.example.logitrack.entity.LigneCommande;
import org.example.logitrack.entity.Produit;
import org.example.logitrack.enums.NotificationType;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @Autowired
    private NotificationClient notificationClient;

    public Commande ajouterCommande(Commande commande, long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec:" + idClient));
        commande.setClient(client);

        Commande savedCommande = commandeRepository.save(commande);

        sendNotification(savedCommande.getId(), "Nouvelle commande créée #" + savedCommande.getId(), NotificationType.ORDER_CREATED);

        return savedCommande;
    }

    public List<Commande> afficherCommandes() {
        return commandeRepository.findAll();
    }

    public Commande consulterCommande(long id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvée avec id: " + id));
    }

    public boolean ajouterProduitCommande(long idProduit, long idCommande, int quantite) {
        Commande commande = commandeRepository.findById(idCommande).orElse(null);
        Produit produit = produitService.consulterProduit(idProduit);

        if (commande == null || produit == null || produit.getQuantiteStock() < quantite) {
            return false;
        }
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setProduit(produit);
        produit.getLignesCommande().add(ligneCommande);
        commande.getLignesCommande().add(ligneCommande);
        commandeRepository.save(commande);
        produitService.ajouterProduit(produit);
        ligneCommandeService.ajouterLigneCommande(ligneCommande);

        return true;
    }

//    public Commande modifierStatutCommande(Long id, String statut) {
//        Commande commande = commandeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'id : " + id));
//
//        NotificationType notificationType = null;
//        String statutActuel = commande.getStatut();
//
//        if (statutActuel == null) {
//            throw new RuntimeException("Erreur : le statut actuel de la commande " + id + " est null");
//        }
//
//        if (statutActuel.equalsIgnoreCase("en attente") && statut.equalsIgnoreCase("Expedié")) {
//            commande.setStatut("Expedié");
//            notificationType = NotificationType.ORDER_SHIPPED;
//
//        } else if (statutActuel.equalsIgnoreCase("Expedié") && statut.equalsIgnoreCase("Livré")) {
//            commande.setStatut("Livré");
//            notificationType = NotificationType.ORDER_DELIVERED;
//
//        } else {
//            throw new RuntimeException(
//                "Erreur : changement de statut impossible pour la commande " + id
//                + ". Statut actuel : '" + statutActuel + "', statut demandé : '" + statut + "'"
//            );
//        }
//
//        Commande updatedCommande = commandeRepository.save(commande);
//
//        if (notificationType != null) {
//            sendNotification(updatedCommande.getId(), "Le statut de votre commande #" + id + " est maintenant : " + statut, notificationType);
//        }
//
//        return updatedCommande;
//    }
public Commande modifierStatutCommande(Long id, String statut) {
    Commande commande = commandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

    commande.setStatut(statut);
    Commande savedCommande = commandeRepository.save(commande);

    if (statut.equalsIgnoreCase("Expedié")) {
        sendNotification(savedCommande.getId(), "Statut de la commande #" + savedCommande.getId() + " modifié : Expedié",
                NotificationType.ORDER_SHIPPED);

    } else if (statut.equalsIgnoreCase("Livré")) {
        sendNotification(savedCommande.getId(), "Statut de la commande #" + savedCommande.getId() + " modifié : Livré",
                NotificationType.ORDER_DELIVERED);
    }
    return savedCommande;



}
    public List<Commande> getCommandesByClientId(Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }

    public Long getTotalOrdersCount() {
        return commandeRepository.countAllOrders();
    }

    public Commande modifierCommande(long id, Commande commandeDetails, Long idClient) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée avec l'id : " + id));
        commande.setDateCommande(commandeDetails.getDateCommande());
        commande.setStatut(commandeDetails.getStatut());
        if (idClient != null) {
            Client client = clientRepository.findById(idClient)
                    .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id : " + idClient));
            commande.setClient(client);
        }
        return commandeRepository.save(commande);
    }

    private void sendNotification(Long orderId, String message, NotificationType type) {
        try {
            NotificationRequestDto request = new NotificationRequestDto(orderId, message, type);
            notificationClient.sendNotification(request);
        } catch (Exception ex) {
            log.error("Échec de l'envoi de la notification pour la commande {}. Raison: {}", orderId, ex.getMessage());
        }
    }
}