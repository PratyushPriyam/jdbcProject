CREATE DATABASE event_management;

USE event_management;

CREATE TABLE Event (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    location VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE Participant (
    participant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

CREATE TABLE Registration (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    participant_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Event(event_id) ON DELETE CASCADE,
    FOREIGN KEY (participant_id) REFERENCES Participant(participant_id) ON DELETE CASCADE
);

