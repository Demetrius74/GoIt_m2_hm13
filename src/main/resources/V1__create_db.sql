CREATE TABLE client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (CHAR_LENGTH(name) >= 3)
);

CREATE TABLE planet (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CHECK (id ~ '^[A-Z0-9]+$')
);

CREATE TABLE ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(50) NOT NULL,
    to_planet_id VARCHAR(50) NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
