
CREATE TABLE enrollments (
    enrollments_id VARCHAR(50) PRIMARY KEY,
    student_code VARCHAR(50) NOT NULL UNIQUE,
    start_time TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL,
    plan_id BIGINT NOT NULL,

    CONSTRAINT fk_client FOREIGN KEY(client_id) REFERENCES clients(id),
    CONSTRAINT fk_plan FOREIGN KEY(plan_id) REFERENCES plans(id)
);