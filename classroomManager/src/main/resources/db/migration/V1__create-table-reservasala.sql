CREATE TABLE reserva_sala (
    id_reserva_sala BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_hora DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL
);
