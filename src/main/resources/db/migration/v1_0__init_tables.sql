CREATE TABLE acces_evenement (
 id serial  not null PRIMARY KEY ,
  user_id bigint(20) NOT NULL,
  ev_id bigint(20) NOT NULL,
  etat int(50) NOT NULL
);


CREATE TABLE acces_livre (
 id serial  not null PRIMARY KEY ,
  user_id bigint(20) NOT NULL,
  book_id bigint(20) NOT NULL,
  etat int(50) NOT NULL
);

CREATE TABLE collection_livre (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL
);

CREATE TABLE condition_deblocage (
 id serial  not null PRIMARY KEY ,
  ev_id bigint(20) NOT NULL,
  book_id bigint(20) NOT NULL
);


CREATE TABLE condition_detail (
 id serial  not null PRIMARY KEY ,
  condition_id bigint(20) NOT NULL,
  ae_id bigint(20) DEFAULT NULL,
  al_id bigint(20) DEFAULT NULL
);


CREATE TABLE developpement (
 id serial  not null PRIMARY KEY ,
  version_id bigint(20) NOT NULL
);


CREATE TABLE espace (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  book_id bigint(20) NOT NULL
);


CREATE TABLE evenement (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  space_id bigint(20) NOT NULL,
  time_id bigint(20) NOT NULL,
  book_id bigint(20) NOT NULL,
  dev_id bigint(20) NOT NULL
);


CREATE TABLE livre (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  collect_id bigint(20) DEFAULT NULL
);


CREATE TABLE temps (
 id serial  not null PRIMARY KEY ,
  annee bigint(20) NOT NULL,
  jour bigint(20) DEFAULT NULL,
  book_id bigint(11) NOT NULL
);


CREATE TABLE texte (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  numero bigint(20) NOT NULL,
  ordre bigint(20) DEFAULT NULL,
  etat int(50) NOT NULL,
  version_id bigint(20) NOT NULL,
  essai_1 varchar(100)  NOT NULL,
  essai_2 varchar(250)  DEFAULT NULL,
  essai_3 varchar(500)  DEFAULT NULL,
  essai_4 varchar(1000)  DEFAULT NULL,
  essai_5 varchar(2000)  DEFAULT NULL,
  essai_6 varchar(4000)  DEFAULT NULL,
  essai_7 varchar(10000)  DEFAULT NULL
);


CREATE TABLE utilisateur (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  email varchar(50)  NOT NULL,
  mot_passe varchar(100)  NOT NULL,
  date_inscription date NOT NULL
);



CREATE TABLE version (
 id serial  not null PRIMARY KEY ,
  nom varchar(100)  NOT NULL,
  numero bigint(20) NOT NULL,
  etat int(50) NOT NULL,
  dev_id bigint(20) DEFAULT NULL
);
