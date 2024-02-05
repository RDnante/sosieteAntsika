insert into poste(nom) values
                 ('employee'),
                 ('chef');
insert into poste(nom) values ('achat');
insert into poste(nom) values ('vente');
insert into poste(nom) values ('RH');

insert into service values (default,'economique');
insert into service values (default,'securite');
insert into service values (default,'magasin');
insert into service values (default,'RH');
insert into service values (default,'Service achat');
insert into service values (default,'Service vente');

insert into login(id_service,id_poste,password) values
                 (1,1,'eco123E'),
                 (1,2,'eco123'),
                 (2,1,'secu123E'),
                 (2,2,'secu123');

insert into login(id_service,id_poste,password) values (4,5,'RH123');
insert into login(id_service,id_poste,password) values (5,1,'A123');
insert into login(id_service,id_poste,password) values (6,4,'V123');

INSERT INTO unite(libelle) VALUES
                ('unite'),
                ('kg'),
                ('litre');

INSERT INTO type_gestion(libelle,type_gestion) VALUES
                        ('LIFO', 'desc'),
                        ('FIFO', 'asc');

insert into categorie values (default,'fourniture');
insert into categorie values (default,'ustensile');
insert into categorie values (default,'aliment');

insert into article values (default,1,'stylo',1,1);
insert into article values  (default,2,'couteau',1,1);
insert into article values  (default,3,'Riz',3,2);

insert into fournisseur values (default,'jumbo','1234');
insert into fournisseur values (default,'cosmos','1234');

insert into stock_fournisseur values (default,1,1,150,340);
insert into stock_fournisseur values (default,2,2,150,340);
insert into stock_fournisseur values (default,1,2,150,340);


insert into entree_stock values (default,1,102,1000,'2023-12-11');
insert into entree_stock values (default,2,100,1500,'2023-12-11');
insert into entree_stock values (default,1,1000,'2023-12-11');


