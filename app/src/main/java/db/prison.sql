DROP TABLE IF EXISTS prisoners;
DROP TABLE IF EXISTS cells;

CREATE TABLE prisoners (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR (50)

);

CREATE TABLE cells (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    prisoner_id INTEGER references prisoners(id)
);


INSERT INTO prisoners (name)
    VALUES ('Jake'),
           ('Andre'),
           ('Cactus')
           ('Dwayne');


INSERT INTO cells
    VALUES ('1', '2')
           ('3', '4');