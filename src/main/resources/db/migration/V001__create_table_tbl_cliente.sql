CREATE TABLE tbl_cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cnpj VARCHAR(14),
    data_cadastro DATE,
    endereco VARCHAR(255),
    nome VARCHAR(255),
    telefone VARCHAR(255)
) ENGINE=InnoDB;