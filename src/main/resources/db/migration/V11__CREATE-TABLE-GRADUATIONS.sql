
CREATE TABLE graduations (
    id BIGSERIAL PRIMARY KEY,

    belt_color VARCHAR(50) NOT NULL,
    degree INT NOT NULL,
    graduation_date DATE NOT NULL,

    client_id BIGINT NOT NULL,

    CONSTRAINT fk_client FOREIGN KEY(client_id) REFERENCES clients(id)
);