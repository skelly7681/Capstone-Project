BEGIN TRANSACTION;

DROP TABLE IF EXISTS invite_restaurant;
DROP TABLE IF EXISTS invites;
DROP TABLE IF EXISTS restaurants;
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

CREATE TABLE invites (
        invite_id serial NOT NULL,
        sender_user_id integer NOT NULL,
        closing_date date,
        closing_time time,
        unique_link varchar (200),
        CONSTRAINT pk_invite_invite_id PRIMARY KEY (invite_id)
);


CREATE TABLE restaurants (
        restaurant_id serial NOT NULL,
        restaurant_name varchar(200),
        restaurant_type varchar (50),
        restaurant_address varchar(200),
        phone_number varchar (20),
        thumbnail_img varchar (200),
        star_rating decimal,
        take_out boolean,
        delivery boolean,
        yelp_key varchar(50),
        CONSTRAINT pk_restaurant_restaurant_id PRIMARY KEY (restaurant_id)
);

CREATE TABLE invite_restaurant (
        invite_id integer,
        restaurant_id integer,
        vetoed boolean
);

ALTER TABLE invites
ADD FOREIGN KEY (sender_user_id)
REFERENCES users(user_id);

ALTER TABLE invite_restaurant
ADD FOREIGN KEY (invite_id)
REFERENCES invites(invite_id);

ALTER TABLE invite_restaurant
ADD FOREIGN KEY (restaurant_id)
REFERENCES restaurants(restaurant_id);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;


