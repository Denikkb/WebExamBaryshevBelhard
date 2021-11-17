INSERT INTO Persons(FirstName, LastName ) VALUES ('Денис', 'Кораблев');
INSERT INTO Persons(FirstName, LastName ) VALUES ('Иван', 'Иванов');
INSERT INTO Persons(FirstName, LastName ) VALUES ('Семен', 'Слепаков');
INSERT INTO Persons(FirstName, LastName ) VALUES ('Илья', 'Муромец');
INSERT INTO Persons(FirstName, LastName ) VALUES ('Добрыня', 'Никитич');
INSERT INTO Persons(FirstName, LastName ) VALUES ('Соловей', 'Разбойник');



INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Молоток', 10, 5, 1);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Отвертка', 3, 3, 1);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Ключ', 2, 6, 2);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Дрель', 150, 60, 2);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Болгарка', 215, 160, 3);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Мечик', 5, 8, 3);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Лобзик', 125, 600, 4);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Пила', 25, 65, 5);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Коронка', 7, 26, 6);
INSERT INTO Products(nameProduct, price, quantity, id_person ) VALUES ('Напильник', 5, 36, 6);



INSERT INTO Orders(id_person, email ) VALUES (1, 'Кораблев@gmail.com');
INSERT INTO Orders(id_person, email ) VALUES (2, 'Кораблев@gmail.com');
INSERT INTO Orders(id_person, email ) VALUES (3, 'Иванов@gmail.com');
INSERT INTO Orders(id_person, email ) VALUES (4, 'Слепаков@gmail.com');
INSERT INTO Orders(id_person, email ) VALUES (5, 'Иванов@gmail.com');
INSERT INTO Orders(id_person, email ) VALUES (6, 'Иванов@gmail.com');