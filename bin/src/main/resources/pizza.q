[QueryItem="1"]
PREFIX : <http://www.w3.org/KRO_project/cosimo/pizza#>
SELECT * WHERE {?x a :Pizza . ?x :hasTopping ?q . ?q a :CheeseTopping }

[QueryItem="2"]
PREFIX : <http://www.w3.org/KRO_project/cosimo/pizza#>
SELECT * WHERE {?x a :CheeseyPizza}
