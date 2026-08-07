-- Mot de passe pour tous les utilisateurs: password123
-- Hash BCrypt généré avec BCryptPasswordEncoder (strength 10)
INSERT INTO users (id, nom, prenom, email, password, role) VALUES
    (1, 'Admin', 'LogiTrack', 'admin@logitrack.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN'),
    (2, 'Manager', 'LogiTrack', 'manager@logitrack.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'MANAGER'),
    (3, 'Agent', 'LogiTrack', 'agent@logitrack.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'AGENT');

INSERT INTO admin (id) VALUES (1);
INSERT INTO manager (id) VALUES (2);

INSERT INTO client (id, nom, prenom,email, telephone, ville) VALUES
    (1, 'Benani', 'Youssef','bennani@gmail.com', '+212600112233', 'Casablanca'),
    (2, 'El Amrani', 'Sara', 'sara@gmail.com','+212677889900', 'Rabat');

INSERT INTO produit (id, nom, categorie, prix, quantite) VALUES
    (1, 'Pc Portable Dell XPS 15', 'Informatique', 15000.00, 20),
    (2, 'Souris Logi MX Master 3S', 'Accessoires', 1200.00, 50),
    (3, 'Ecran Dell 27 4K', 'Peripheriques', 4500.00, 15);

INSERT INTO commande (id, date_commande, statut, client_id) VALUES
    (1, '2026-08-01', 'EN_COURS', 1),
    (2, '2026-08-05', 'LIVRE', 2);

INSERT INTO ligne_commande (id, quantite, commande_id, produit_id) VALUES
    (1, 1, 1, 1),
    (2, 2, 1, 2),
    (3, 1, 2, 3);