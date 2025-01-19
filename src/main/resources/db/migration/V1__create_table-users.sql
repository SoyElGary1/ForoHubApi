CREATE TABLE users (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      nombre VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
