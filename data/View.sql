create or replace view commande_livraison as 
select bon_de_commande.id_bon_de_commande,bon_de_commande.date_confirmation, bon_de_commande.id_fournisseur, bon_de_commande_commandes.id_commande from bon_de_commande_commandes, bon_de_commande 
where bon_de_commande.id_bon_de_commande = bon_de_commande_commandes.id_bon_de_commande;

create or replace view etatstock as
    select es.id_article ,(sum(es.quantite) - sum(ss.quantite_total)) as quantite from entree_stock as es
    join sortie_stock ss on es.id_article = ss.id_article
    group by es.id_article;

    select es.id_article from entree_stock as es
    join sortie_stock ss on es.id_article = ss.id_article;

create or replace view marge_brute as
    select entree_stock.id_article,(sum(entree_stock.quantite)) from entree_stock
    join sortie_stock ss on entree_stock.id_article = ss.id_article
    group by entree_stock.id_article;
    select (select sum(quantite) from entree_stock) as quantite_entant;