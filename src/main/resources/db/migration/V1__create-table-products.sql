CREATE TABLE tb_product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT DEFAULT 'SEM DESCRIÇÃO',
    stock INT DEFAULT 0,
    price BIGINT NOT NULL
);
