CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha TIMESTAMP NOT NULL,
                         status BOOLEAN NOT NULL,
                         user_id BIGINT NOT NULL,
                         curso VARCHAR(255),
                         CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
