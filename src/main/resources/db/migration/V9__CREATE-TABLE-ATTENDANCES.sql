CREATE TABLE attendances (
    attendances_id VARCHAR(50) PRIMARY KEY,

    attendance_date DATE NOT NULL,
    client_id VARCHAR(50) NOT NULL,
    class_id VARCHAR(50) NOT NULL,

    CONSTRAINT fk_client FOREIGN KEY(client_id) REFERENCES clients(id),
    CONSTRAINT fk_class FOREIGN KEY(class_id) REFERENCES classes(id),

    UNIQUE(client_id, class_id, attendance_date)
);