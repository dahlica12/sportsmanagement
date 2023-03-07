USE `sportsmanagement-db`;

create table if not exists athletes (
                                       id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       athlete_id VARCHAR(36),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    sport_name VARCHAR(50),
    points_won DECIMAL(8, 2),
    games_won DECIMAL(8, 2),
    games_lost DECIMAL(8, 2),
    height DECIMAL(8, 2),
    weight DECIMAL(8, 2),
    age DECIMAL(8, 2),
    gender VARCHAR(50),
    status VARCHAR(50)
    );
create table if not exists coaches (
                                         id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         coach_id VARCHAR(36),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    phone_number VARCHAR(50),
    salary DECIMAL(8, 2),
    title VARCHAR (50)
    );


create table if not exists sports (
                                           id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           sport_id VARCHAR(36),
    name VARCHAR(100)
    );


create table if not exists events (
                                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        event_id VARCHAR(50),
    sport_id VARCHAR(36),
    event_type VARCHAR(50),
    status VARCHAR(50),
    score VARCHAR(9),
    thedate VARCHAR (8),
    duration VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9)
    );