CREATE SEQUENCE customer_ids;
CREATE TABLE customer ( id integer PRIMARY KEY DEFAULT NEXTVAL('customer_ids'), 
					firstname varchar NOT NULL, lastname varchar NOT NULL, 
					email varchar NOT NULL UNIQUE );
/*options*/
CREATE SEQUENCE base_options_ids;
CREATE TABLE base_options (id integer PRIMARY KEY DEFAULT NEXTVAL('base_options_ids'), 
						name varchar NOT NULL UNIQUE, 
						disable boolean DEFAULT false);
INSERT INTO base_options (name) VALUES ('завтрак'),('уборка');
CREATE SEQUENCE price_options_ids;
CREATE TABLE price_options (id integer PRIMARY KEY DEFAULT NEXTVAL('price_options_ids'), 
				id_base_options integer REFERENCES base_options(id),
				data_price date NOT NULL DEFAULT current_date, 
				price money NOT NULL, 
				disable boolean NOT NULL DEFAULT false);
INSERT INTO price_options (id_base_options,data_price,price) VALUES (1,'2018-02-11',5),(2,'2018-02-11',10);
INSERT INTO price_options (id_base_options,price) VALUES (1,7),(2,11);
/*category*/
CREATE SEQUENCE category_ids;
CREATE TABLE category (id integer PRIMARY KEY DEFAULT NEXTVAL('category_ids'), name varchar NOT NULL UNIQUE, description text NOT NULL);
INSERT INTO category (name,description) VALUES ('Apartment','апартаменты, аналог квартиры, состоящей из нескольких комнат и кухни'), 
					('Business', 'виды номеров в отеле с большой площадью, компьютером и факсом, предназначенный для работы'),
					('Standart','стандартная комната');
/*room*/
CREATE TABLE rooms (number_room int PRIMARY KEY,
					category integer REFERENCES category(id), 
					disable boolean NOT NULL DEFAULT false);
INSERT INTO rooms (number_room,category) 
	VALUES (101,3),(102,3),(103,3),
			(201,2),(202,2),(203,2),
			(301,1),(302,1),(303,1);
CREATE SEQUENCE price_room_ids;
CREATE TABLE price_room (id integer PRIMARY KEY DEFAULT NEXTVAL('price_room_ids'),
						id_category integer REFERENCES category(id),
						data_price date NOT NULL DEFAULT current_date,
						price money NOT NULL,
						disable boolean NOT NULL DEFAULT false);
INSERT INTO price_room (id_category,data_price,price) VALUES (1,'2018-02-11',45),(2,'2018-02-11',32),(3,'2018-02-10',18);
INSERT INTO price_room (id_category,price) VALUES (1,50),(2,30),(3,20);
/**/
CREATE TABLE orders (id uuid PRIMARY KEY,
			id_costumer int REFERENCES customer(id),
			date_registration date NOT NULL,
			price money NOT NULL,
			id_room integer REFERENCES rooms(number_room),
			disable boolean DEFAULT false);
CREATE TABLE order_options (id_order uuid REFERENCES orders(id),
				id_options integer REFERENCES base_options(id));
