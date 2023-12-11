    create database syscom;
\c syscom

create table poste(
    id_poste serial primary key,
    nom varchar(30)
);
create table service (
    id_service serial primary key,
    nom varchar(30)
);

create table login(
    id_login serial primary key,
    id_service int references service(id_service),
    id_poste int references poste(id_poste),
    password varchar(30)
);

create table categorie (
    id_categorie serial primary key,
    nom varchar(40)
);

CREATE TABLE type_gestion(
    id_type_gestion SERIAL PRIMARY KEY,
    libelle VARCHAR(50),
    type_gestion VARCHAR(50)
);

CREATE TABLE unite(
    id_unite SERIAL PRIMARY KEY,
    libelle VARCHAR(50)
);

create table article (
    id_article serial primary key,
    id_categorie int references categorie(id_categorie),
    nom varchar(40),
    id_unite int references unite(id_unite),
    id_type_gestion int references type_gestion(id_type_gestion)
);

create table service_besoin (
    id_service_besoin serial primary key,
    id_service int references service(id_service),
    id_article int references article(id_article),
    quantite decimal,
    date date default current_date,
    status int
);

create table fournisseur (
    id_fournisseur serial primary key,
    nom varchar(50),
    mdp varchar(30)
);


create table stock_fournisseur (
    id_stock_fournisseur serial primary key,
    id_fournisseur int references fournisseur(id_fournisseur),
    id_article int references article(id_article),
    quantite decimal,
    prix_unitaire decimal
);

create table commande(
    id_commande serial primary key,
    nom varchar(50),
    date varchar(50),
    livraison_partielle boolean,
    mode_paiement varchar(50),
    categorie varchar(50),
    designation varchar(50),
    quantite decimal,
    tva decimal,
    ttc decimal,
    id_service_besoin int
);

create table bon_de_commande (
    id_bon_de_commande serial primary key,
    id_fournisseur int references fournisseur(id_fournisseur),
    date_confirmation DATE DEFAULT CURRENT_DATE
);

create table bon_de_commande_commandes (
    id_bon_de_commande_commande serial primary key,
    id_bon_de_commande int references  bon_de_commande(id_bon_de_commande),
    id_commande int references commande(id_commande)
);

CREATE TABLE entree_stock(
    id_entree_stock SERIAL PRIMARY KEY,
    id_article INT,
    quantite DECIMAL,
    prix_unitaire DECIMAL,
    date_entree DATE,
    FOREIGN KEY (id_article) REFERENCES article(id_article)
);

CREATE TABLE sortie_stock(
    id_sortie_stock SERIAL PRIMARY KEY,
    id_article INT,
    quantite_total DECIMAL,
    date_sortie DATE,
    FOREIGN KEY (id_article) REFERENCES article(id_article)
);

CREATE TABLE mouvement_sortie(
    id_mouvement_sortie SERIAL PRIMARY KEY,
    id_sortie_stock INT,
    id_entree_stock INT,
    id_article INT,
    quantite DECIMAL,
    prix_unitaire DECIMAL,
    FOREIGN KEY (id_article) REFERENCES article(id_article),
    FOREIGN KEY (id_entree_stock) REFERENCES entree_stock(id_entree_stock),
    FOREIGN KEY (id_sortie_stock) REFERENCES sortie_stock(id_sortie_stock)
);
