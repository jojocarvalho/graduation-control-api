
CREATE TABLE classes (
    classes_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    day_of_week VARCHAR(20),
    class_time TIME NOT NULL
);