
INSERT INTO estatetype (id, estatetype) VALUES (1, 'Mieszkanie');
INSERT INTO estatetype (id, estatetype) VALUES (2, 'Dom');
INSERT INTO estatetype (id, estatetype) VALUES (3, 'Dzialka');

INSERT INTO role (id, role) VALUES (1, 'Administrator');
INSERT INTO role (id, role) VALUES (2, 'Uzytkownik');

INSERT INTO transactiontype (id, transactiontype) VALUES (1, 'Wynajem');
INSERT INTO transactiontype (id, transactiontype) VALUES (2, 'Sprzedaz');

INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (1, 5, 5,'12-345', 'Floriańska', 'Kraków');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (2, 5, 5,'12-345', 'Floriańska', 'Kraków');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (3, 5, 5,'12-345', 'Floriańska', 'Kraków');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (4, 5, 5,'12-345', 'Lwowska', 'Rzeszów');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (5, 5, 5,'12-345', 'Lwowska', 'Rzeszów');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (6, 5, 5,'12-345', 'Lwowska', 'Rzeszów');
INSERT INTO address (id, apartmentno, houseno, postalcode, street, town) VALUES (7, 5, 5,'12-345', 'Lwowska', 'Rzeszów');

INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id) VALUES (1, 'mail1@mail.com', 'login', 'Adam', 'login', '666555444', 1, 2);
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id) VALUES (2, 'mail2@mail.com', 'user', 'Mateusz', 'user', '666555333', 2, 2);
INSERT INTO userek (user_id, email, login, name, password, phonenumber, address_id, role_id) VALUES (3, 'mail2@mail.com', 'admin', 'Kamil', 'admin', '666555222', 3, 1);

INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (1, 'Oferta 1', 100, 'Opis1', '3', true, 2000, 4, 1, 1);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (2, 'Oferta 2', 150, 'Opis2', '2', false, 700000, 5, 2, 2);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (3, 'Oferta 3', 100, 'Opis3', '5', true, 500000, 6, 1, 2);
INSERT INTO offer (offer_id, offername, area, description, floor, garage, price, address_id, estatetype_id, transactiontype_id) VALUES (4, 'Oferta 4', 40, 'Opis4', '3', true, 200000, 7, 1, 2);

INSERT INTO owner_offer (user_id, offer_id) VALUES (1, 1);
INSERT INTO owner_offer (user_id, offer_id) VALUES (1, 2);
INSERT INTO owner_offer (user_id, offer_id) VALUES (2, 4);
INSERT INTO owner_offer (user_id, offer_id) VALUES (3, 3);

INSERT INTO favourites (user_id, offer_id) VALUES (3, 1);
INSERT INTO favourites (user_id, offer_id) VALUES (2, 3);