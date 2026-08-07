CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE admin (
    id BIGINT PRIMARY KEY,
    CONSTRAINT fk_admin_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE manager (
    id BIGINT PRIMARY KEY,
    CONSTRAINT fk_manager_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE agent (
    id BIGINT PRIMARY KEY,
    CONSTRAINT fk_agent_users FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    telephone VARCHAR(20),
    ville VARCHAR(100)
);

CREATE TABLE produit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(150) NOT NULL,
    categorie VARCHAR(100),
    prix DOUBLE NOT NULL,
    quantite INT NOT NULL DEFAULT 0
);

CREATE TABLE commande (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_commande DATE,
    statut VARCHAR(50),
    client_id BIGINT,
    CONSTRAINT fk_commande_client FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE SET NULL
);

CREATE TABLE ligne_commande (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantite INT NOT NULL,
    commande_id BIGINT,
    produit_id BIGINT,
    CONSTRAINT fk_ligne_commande FOREIGN KEY (commande_id) REFERENCES commande(id) ON DELETE CASCADE,
    CONSTRAINT fk_ligne_produit FOREIGN KEY (produit_id) REFERENCES produit(id) ON DELETE RESTRICT
);