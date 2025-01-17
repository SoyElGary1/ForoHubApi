CREATE TABLE users (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Clave primaria
                      nombre VARCHAR(255) NOT NULL,         -- Campo de nombre del usuario
                      email VARCHAR(255) NOT NULL UNIQUE    -- Campo email, debe ser único
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
