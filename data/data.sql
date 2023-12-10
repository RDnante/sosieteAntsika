insert into poste(nom) values
                 ('employee'),
                 ('chef'),
                 ('achat'),
                 ('vente');

insert into service values (default,'economique');
insert into service values (default,'securite');
insert into service values (default,'magasin');
insert into service values (default,'RH');

insert into login(id_service,id_poste,password) values
                 (1,1,'eco123E'),
                 (1,2,'eco123'),
                 (2,1,'secu123E'),
                 (2,2,'secu123'),
                 (3,1,'mag123E'),
                 (3,2,'mag123'),
                 (3,3,'mag123A'),
                 (3,4,'mag123V');
insert into login(id_service,id_poste,password) values (4,2,'RH123');

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