CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    loja_responsavel VARCHAR(100) NOT NULL,
    origem_id INT,
    destino_id INT,
    data_criacao TIMESTAMP NOT NULL
);