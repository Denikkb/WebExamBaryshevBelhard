CREATE TABLE Persons (
PersonId int AUTO_INCREMENT  PRIMARY KEY,
FirstName varchar(255) NOT NULL,
LastName varchar(255) NOT NULL
);

CREATE TABLE Products (
id int AUTO_INCREMENT  PRIMARY KEY,
nameProduct varchar(255) NOT NULL,
price int NOT NULL,
quantity int  NOT NULL,
id_person int,
FOREIGN KEY (id_person) REFERENCES Persons(PersonId)
);

CREATE TABLE Orders (
id int AUTO_INCREMENT  PRIMARY KEY,
id_person int,
email varchar(255) NOT NULL,
FOREIGN KEY (id_person) REFERENCES Persons(PersonId)

);


