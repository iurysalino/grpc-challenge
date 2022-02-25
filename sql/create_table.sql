CREATE TABLE IF NOT EXISTS products (
    id SERIAL,
    name varchar(255) NOT NULL UNIQUE,
    stock INTEGER NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS shopping_cart (
    id SERIAL,
    id_client INTEGER NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS products_shopping_cart (
    id SERIAL,
    id_shopping_cart INTEGER NOT NULL,
    id_product INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_shopping_cart) REFERENCES shopping_cart (id),
    FOREIGN KEY (id_product) REFERENCES products (id)
);