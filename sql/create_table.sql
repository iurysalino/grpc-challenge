CREATE TABLE IF NOT EXISTS products (
    id SERIAL,
    name varchar(255) NOT NULL,
    stock INTEGER NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);