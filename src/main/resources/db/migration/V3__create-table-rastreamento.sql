CREATE TABLE rastreamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    entrega_id INT NOT NULL,
    descricao_localizacao VARCHAR(255) NOT NULL,
    endereco_id INT NOT NULL,
    data_hora TIMESTAMP NOT NULL
);