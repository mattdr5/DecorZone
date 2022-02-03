DROP DATABASE IF EXISTS decorzone;
CREATE DATABASE decorzone;
USE decorzone;

/* Creazione tabella utente*/
DROP TABLE IF EXISTS utente;
CREATE TABLE utente
 (
   email varchar(30) primary key not null,
   nome varchar(30) not null,
   cognome varchar(30) not null,
   password varchar(30) not null,
   numeroDiTelefono varchar(13) not null,
   ruolo tinyint not null,
   sesso varchar(1) not null,
   via varchar(30),
   città varchar(30),
   CAP varchar(5)
 );

 /* Creazione tabella carta*/
 DROP TABLE IF EXISTS carta;
 CREATE TABLE carta
  (
    numeroCarta varchar(16) primary key not null,
    CVC varchar(3) not null,
    intestatario varchar(25) not null,
    fk_utente varchar(30),
    FOREIGN KEY (fk_utente)
     REFERENCES utente(email)
     ON UPDATE CASCADE
     ON DELETE NO ACTION
  );

/* Creazione tabella categoria*/
DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria
 (
   idCategoria int primary key AUTO_INCREMENT not null,
   nomeCategoria varchar(45) not null
 );
 ALTER TABLE categoria AUTO_INCREMENT=1; /*  set the start number for auto increment primary key */


/* Creazione tabella prodotti */
DROP TABLE IF EXISTS prodotto;
CREATE TABLE prodotto
 (
   idProdotto int primary key AUTO_INCREMENT not null,
   fk_categoria int,
   FOREIGN KEY (fk_categoria)
    REFERENCES categoria(idCategoria)
    ON UPDATE CASCADE
    ON DELETE SET NULL,
   nomeProdotto varchar(45) not null,
   descrizione varchar(200) ,
   prezzoProdotto decimal(10,2) not null,
   srcImg varchar(50),
   quantitàDisponibile int(100) not null,
   colore varchar(7) not null,
   dimensione varchar(30) not null
);
ALTER TABLE prodotto AUTO_INCREMENT=1; /*  set the start number for auto increment primary key */

/*---------------------------------------------------------------------------------------------*/

/* Creazione tabella ordine */
DROP TABLE IF EXISTS ordine;
CREATE TABLE ordine
 (
   idOrdine int primary key AUTO_INCREMENT not null,
   totaleOrdine decimal(10,2) not null,
   dataOridine date not null,
   quantitàtotale int (10) not null,
   indirizzoSpedizione varchar(30),
  fk_utente varchar(30),
    FOREIGN KEY (fk_utente)
     REFERENCES utente(email)
     ON UPDATE CASCADE
     ON DELETE NO ACTION
);
ALTER TABLE ordine AUTO_INCREMENT=1; /*  set the start number for auto increment primary key */

/*---------------------------------------------------------------------------------------------*/


/* Creazione tabella dettaglio_ordine */
DROP TABLE IF EXISTS ordine_prodotto;
CREATE TABLE ordine_prodotto
(
    idOrdine_Prod int primary key AUTO_INCREMENT not null,
    qntAcquistata int not null,
    prezzoUnit decimal(10,2) not null,
    subTotale decimal(10,2) not null,
    fk_prodotto int,
      FOREIGN KEY (fk_prodotto)
       REFERENCES prodotto(idProdotto)
       ON UPDATE CASCADE
       ON DELETE SET NULL,
    fk_ordine int NOT NULL,
    FOREIGN KEY (fk_ordine)
     REFERENCES ordine(idOrdine)
     ON UPDATE CASCADE
     ON DELETE CASCADE
);
ALTER TABLE ordine_prodotto AUTO_INCREMENT=1;/* set the start number for auto increment primary key */

/*---------------------------------------------------------------------------------------------------*/



/* Query Inserimento prodotti */

INSERT INTO categoria
  VALUES
  (
	1,
    "Divani"
  );

  INSERT INTO categoria
  VALUES
  (
	2,
    "Tavoli"
  );
  
  INSERT INTO categoria
  VALUES
  (
	3,
    "Letti"
  );
  
  INSERT INTO categoria
  VALUES
  (
	4,
	"munnezz"
  );

INSERT INTO prodotto(`idProdotto`, `fk_categoria`, `nomeProdotto`, `descrizione`, `prezzoProdotto`, `quantitàDisponibile`, `colore`, `dimensione`) 
VALUES ('1', '1', 'ps5', 'fvb', '345', '5', 'grigio', '100*100');


  INSERT INTO prodotto
    VALUES
    (
      (SELECT max(idProdotto)+1 from prodotto as t1), /*chiave*/
        1,  /*id Categoria*/
      "divano tattico", /*nomeProdotto*/
      "PlayStation Gamma Chassis, 4K HDR, 1 TB",  /*descrizione*/
      399.99, /*prezzoProdotto*/
      NULL, /*foto*/
      20, /*quantitàDisponibile*/
      "giallo", /*colore*/
      "200 cm * 100 cm * 19 cm" /*dimensione*/
    );

    INSERT INTO prodotto
      VALUES
      (
        (SELECT max(idProdotto)+1 from prodotto as t1), /*chiave*/
          1,  /*id Categoria*/
        "Guns N' Roses - Appetite For", /*nomeProdotto*/
        "Il leggendario Album di debutto dei Guns N' Roses per la prima volta rimasterizzato
        a partire dai nastri analogici originali. Nel CD2 brani inediti, live, b-side, versioni acustiche ", /*descrizione*/
        15.50, /*prezzoProdotto*/
        NULL, /*foto*/
        30, /*quantitàDisponibile*/
        "blu", /*colore*/
        "300 cm * 15 cm * 45 cm" /*dimensione*/
      );


      INSERT INTO utente(`email`,`nome`, `cognome`, `password` , `numeroDitelefono`, `ruolo` , `sesso` )
        VALUES
        (
          "b.luke3199@gmail.com", /* email */
          "Luke", /* nome */
          "Boffa", /*cognome */
          "tiPiacerrebbeSaperla01", /* password */
          "3488688089", /* numeroDiTelefono */
		   1 , /* ruolo */
           "M" /* sesso */
        );

        INSERT INTO utente
          VALUES
          (
            "m.dellarocca@gmail.com", /* email */
            "Matteo", /* nome*/
            "Della Rocca", /* cognome*/
            "tiPiacerrebbeSaperla02", /* password*/
            "3458671237", /* numeroDiTelefono*/
            0,  /* ruolo */
            "M", /* sesso */
            "via di mezzo", /* via */
            "Fisciano", /* città */
            "84084" /*cap*/
          );
