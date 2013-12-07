
INSERT INTO estatetype (id, estatetype) VALUES (10001, 'Mieszkanie');
INSERT INTO estatetype (id, estatetype) VALUES (10002, 'Dom');
INSERT INTO estatetype (id, estatetype) VALUES (10003, 'Dzialka');

INSERT INTO role (id, role) VALUES (10001, 'Administrator');
INSERT INTO role (id, role) VALUES (10002, 'Uzytkownik');

INSERT INTO transactiontype (id, transactiontype) VALUES (10001, 'Wynajem');
INSERT INTO transactiontype (id, transactiontype) VALUES (10002, 'Sprzedaz');

INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (10001, 5, 5,'12-345', 'Florianska', 'Krakow');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (10002, 5, 5,'12-345', 'Lwowska', 'Rzeszów');

INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id) VALUES (10001, 'mail1@mail.com', 'login1', 'imie1', 'haslo1', 'nrTelefonu1', 10001, 10002);
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id, sessionid) VALUES (10002, 'mail2@mail.com', 'user1', 'imieUsera1', 'user1', 'nrTelefonu2', 10002, 10002, 'sessionid1');
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id, sessionid) VALUES (10003, 'mail2@mail.com', 'admin1', 'imie2', 'admin1', 'nrTelefonu2', 10001, 10001, 'sessionid1');

INSERT INTO offer (offer_id, area, creationdate, description, finishdate, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10001, 100, '1971-07-13', 'Opis1', '1971-07-13', '3', true, 200000, 10001, 10001, 10001);
INSERT INTO offer (offer_id, area, creationdate, description, finishdate, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10002, 150, '1972-07-13', 'Opis2', '1972-07-13', '2', false, 400000, 10001, 10002, 10001);
INSERT INTO offer (offer_id, area, creationdate, description, finishdate, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10003, 100, '1973-07-13', 'Opis3', '1973-07-13', '5', true, 500000, 10002, 10001, 10002);
INSERT INTO offer (offer_id, area, creationdate, description, finishdate, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (10004, 100, '1974-07-13', 'Opis4', '1974-07-13', '3', true, 200000, 10002, 10001, 10002);

INSERT INTO owner_offer (user_id, offer_id) VALUES (10001, 10001);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10001, 10002);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10002, 10004);
INSERT INTO owner_offer (user_id, offer_id) VALUES (10003, 10003);

INSERT INTO favourites (user_id, offer_id) VALUES (10003, 10001);
INSERT INTO favourites (user_id, offer_id) VALUES (10002, 10003);