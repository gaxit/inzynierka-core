
INSERT INTO estatetype (id, estatetype) VALUES (1, 'MIESZKANIE');
INSERT INTO estatetype (id, estatetype) VALUES (2, 'DOM');
INSERT INTO estatetype (id, estatetype) VALUES (3, 'DZIAŁKA');
INSERT INTO role (id, role) VALUES (1, 'ADMIN');
INSERT INTO role (id, role) VALUES (2, 'USER');
INSERT INTO role (id, role) VALUES (42, 'USER');
INSERT INTO transactiontype (id, transactiontype) VALUES (1, 'WYNAJEM');
INSERT INTO transactiontype (id, transactiontype) VALUES (2, 'SPRZEDAŻ');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (3,5,5,'12345','KRAKOWSKA','KRAKOW');
INSERT INTO userek (id,email,login,name,password,phonenumber,address_id,role_id) VALUES (42,'email1','test1','Testowy1','test','2345',3,42);
INSERT INTO userek (id,email,login,name,password,phonenumber,address_id,role_id) VALUES (43,'email2','test2','Testowy2','test','2345',3,2);
--INSERT INTO offer_offer (id, favorites_id) VALUES (42,42);
--INSERT INTO offer_offer (id, favorites_id) VALUES (43,43);

--INSERT INTO estatetype (id, estatetype) VALUES (1, 'Mieszkanie');
--INSERT INTO estatetype (id, estatetype) VALUES (2, 'Dom');
--INSERT INTO estatetype (id, estatetype) VALUES (3, 'Dzialka');
--INSERT INTO role (id, role) VALUES (3, 'Administrator');
--INSERT INTO role (id, role) VALUES (2, 'Uzytkownik');
--INSERT INTO transactiontype (id, transactiontype) VALUES (1, 'Wynajem');
--INSERT INTO transactiontype (id, transactiontype) VALUES (2, 'Sprzedaz');
--INSERT INTO transactiontype (id, transactiontype) VALUES (2, 'Sprzedaz');
