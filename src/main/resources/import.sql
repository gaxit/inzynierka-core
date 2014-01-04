
INSERT INTO estatetype (id, estatetype) VALUES (10001, 'Mieszkanie');
INSERT INTO estatetype (id, estatetype) VALUES (10002, 'Dom');
INSERT INTO estatetype (id, estatetype) VALUES (10003, 'Dzialka');

INSERT INTO role (id, role) VALUES (10001, 'Administrator');
INSERT INTO role (id, role) VALUES (10002, 'Uzytkownik');

INSERT INTO transactiontype (id, transactiontype) VALUES (10001, 'Wynajem');
INSERT INTO transactiontype (id, transactiontype) VALUES (10002, 'Sprzedaz');

INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (10001, 5, 5,'12-345', 'Florianska', 'Krakow');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (10002, 5, 5,'12-345', 'Lwowska', 'Rzeszów');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (10003, 5, 5,'12-345', 'Lwowska', 'Rzeszów');

INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id) VALUES (10001, 'mail1@mail.com', 'login', 'imie1', 'login', 'nrTelefonu1', 10001, 10002);
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id, sessionid) VALUES (10002, 'mail2@mail.com', 'user', 'imieUsera1', 'user', 'nrTelefonu2', 10003, 10002, 'sessionid1');
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id, sessionid) VALUES (10003, 'mail2@mail.com', 'admin', 'imie2', 'admin', 'nrTelefonu2', 10001, 10001, 'sessionid1');

INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10001, 'Oferta 1', 100, 'Opis1', '3', true, 200000, 10001, 10001, 10001);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10002, 'Oferta 2', 150, 'Opis2', '2', false, 400000, 10001, 10002, 10001);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10003, 'Oferta 3', 100, 'Opis3', '5', true, 500000, 10001, 10001, 10002);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10004, 'Oferta 4', 100, 'Opis4', '3', true, 200000, 10002, 10001, 10002);

INSERT INTO owner_offer (user_id, offer_id) VALUES (10001, 10001);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10001, 10002);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10002, 10004);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10003, 10003);

INSERT INTO favourites (user_id, offer_id) VALUES (10003, 10001);
INSERT INTO favourites (user_id, offer_id) VALUES (10002, 10003);