/*
	PIZZA BASE
*/

CREATE TABLE deep_pan_base (
	name varchar
);
CREATE TABLE thin_crispy_base (
	name varchar
);

CREATE TABLE pizza (
	name varchar
);
CREATE TABLE users (
	id serial PRIMARY KEY,
	username varchar,
	full_name varchar,
	country varchar,
	created_at varchar,
	email varchar
);
CREATE TABLE bought (
	name_pizza varchar,
	id int
);

/*
	RELATIONS
*/
CREATE TABLE has_tcb(
	name_pizza varchar,
	base varchar
);
CREATE TABLE has_dpb (
	name_pizza varchar,
	base varchar
);


CREATE TABLE has_cheese (
	name_pizza varchar,
	name varchar
);

CREATE TABLE has_fruit (
	name_pizza varchar,
	name varchar
);

CREATE TABLE has_meat (
	name_pizza varchar,
	name varchar
);

CREATE TABLE has_nut (
	name_pizza varchar,
	name varchar
);
CREATE TABLE has_sauce(
	name_pizza varchar,
	name varchar
);
CREATE TABLE has_seafood (
	name_pizza varchar,
	name varchar
);
CREATE TABLE has_herbspice(
	name_pizza varchar,
	name varchar
);
CREATE TABLE has_spicy(
	name_pizza varchar,
	name varchar
);
CREATE TABLE has_vegetable (
	name_pizza varchar,
	name varchar
);

/*
	PIZZA TOPPING
*/
CREATE TABLE cheese_topping (
	name varchar
);
CREATE TABLE fruit_topping ( 
	name varchar
);
CREATE TABLE herb_spice_topping ( 
	name varchar
);
CREATE TABLE meat_topping (
	name varchar
);
CREATE TABLE nut_topping (
	name varchar
);
CREATE TABLE sauce_topping (
	name varchar
);
CREATE TABLE seafood_topping ( 
	name varchar
);
CREATE TABLE spicy_topping ( 
	name varchar
);
CREATE TABLE vegetable_topping ( 
	name varchar
);


\copy fruit_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/fruits.csv DELIMITER ',' CSV;


\copy deep_pan_base FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/grains.csv DELIMITER ',' CSV;
\copy deep_pan_base FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/rice.csv DELIMITER ',' CSV;


\copy thin_crispy_base FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/grains.csv DELIMITER ',' CSV;
\copy thin_crispy_base FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/rice.csv DELIMITER ',' CSV;


\copy vegetable_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/beans.csv DELIMITER ',' CSV;
\copy vegetable_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/mushrooms.csv DELIMITER ',' CSV;
\copy vegetable_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/squash.csv DELIMITER ',' CSV;
\copy vegetable_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/vegetables.csv DELIMITER ',' CSV;


\copy nut_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/nuts_seed.csv DELIMITER ',' CSV;


\copy spicy_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/spicy.csv DELIMITER ',' CSV;


\copy herb_spice_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/pepper.csv DELIMITER ',' CSV;

\copy seafood_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/sea_vegetables.csv DELIMITER ',' CSV;


\copy cheese_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/cheese.csv DELIMITER ',' CSV;


\copy meat_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/meat.csv DELIMITER ',' CSV;


\copy sauce_topping FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/sauces.csv DELIMITER ',' CSV;

\copy pizza FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/pizza.csv DELIMITER ',' CSV;


\copy bought FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/bought.csv DELIMITER ',' CSV;

\copy users(username,full_name,country,created_at,email) FROM /home/cosimo/Desktop/University/ontology_database/kro/PROJECT/JProject/src/main/resources/pizza_data/users.csv DELIMITER ',' HEADER CSV;
