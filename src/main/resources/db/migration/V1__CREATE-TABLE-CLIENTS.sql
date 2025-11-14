
CREATE TABLE clients (
    client_id VARCHAR(43) PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    age INT,
    address VARCHAR(255)
);











