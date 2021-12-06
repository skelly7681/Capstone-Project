BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;

Start Transaction;

Create table invites(
invite_id serial NOT NULL,
sender_user_id integer NOT NULL,
closing_date date,
closing_time time,
unique_link varchar (200));

create table invite_restaurant(
invite_id integer,
restaurant_id integer,
vetoed boolean));

create table restaurants(
restaurant_id serial NOT NULL,
restaurant_name varchar(200),
restaurant_address varchar(200),
open_time time,
closing_time time,
phone_number varchar (20),
thumbnail_img varchar (200),
star_rating integer,
take_out boolean,
delivery boolean));

rollback transaction;
