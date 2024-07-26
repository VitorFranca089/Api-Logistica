CREATE TABLE enderecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    unidade VARCHAR(50),
    bairro VARCHAR(100),
    localidade VARCHAR(100),
    uf VARCHAR(2),
    ibge VARCHAR(10),
    gia VARCHAR(10),
    ddd VARCHAR(3),
    siafi VARCHAR(10)
);