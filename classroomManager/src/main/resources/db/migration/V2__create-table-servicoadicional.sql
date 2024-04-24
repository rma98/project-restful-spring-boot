CREATE TABLE servico_adicional (
    id_servico_adicional BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    custo DECIMAL(10,2) NOT NULL
);
