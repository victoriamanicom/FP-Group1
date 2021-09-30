CREATE TABLE atm_point (
    atm_id int PRIMARY KEY,
    operator varchar(255),
    street_name varchar(255),
    postcode varchar(255),
    latitude decimal(15,13),
    longitude decimal(17,15) 	  
);
CREATE TABLE atm_transaction (
    timestamp varchar(255),
    atm_id int,
    card_number bigint FOREIGN KEY,
    type varchar(255),
    amount decimal(5,2),
    id bigint PRIMARY KEY AUTO_INCREMENT
  
);
CREATE TABLE bank_card(
    bank_card_id int PRIMARY KEY,
    card_number bigint FOREIGN KEY,
    sortcode varchar(255),
    bank_account_id int,
    account_number bigint,
    bank varchar(255)	  
);

CREATE TABLE citizen (
    citizen_id varchar(255) PRIMARY KEY,
    forenames varchar(255),
    surname varchar(255),
    home_address varchar(255),
    date_of_birth varchar(255),
    place_of_birth varchar(255),
    sex varchar(255)		  
);

CREATE TABLE epos (
    id bigint PRIMARY KEY,
    vendor varchar(255),
    street_name varchar(255),
    postcode varchar(255),
    latitude decimal(15,13),
    longitude decimal(17,15)	  
);

CREATE TABLE epos_transactions (
    timestamp varchar(255),
    epos_id bigint,
    card_number bigint,
    payee_account bigint,
    amount decimal(6,2),	
    id bigint PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE mobile_call_records (
    timestamp varchar(255),
    caller_msisdn varchar(255) ,
    call_cell_tower_id bigint,
    receiver_msisdn varchar(255),
    receiver_tower_id bigint,
    id bigint PRIMARY KEY AUTO_INCREMENT	  
);

CREATE TABLE passport (
    passport_number int primary key,
    surname varchar(255),
    given_name varchar(255),
    nationality varchar(255),
    dob varchar(255),
    sex varchar(255),
    place_of_birth varchar(255),
    issuing_country varchar(255),
    date_of_issue varchar(255),
    date_of_expiry varchar(255)
);

CREATE TABLE people_bank_account (
    bank_account_id bigint PRIMARY KEY,
    account_number bigint,
    bank varchar(255),
    forenames varchar(255),
    surname varchar(255),
    date_of_birth varchar(255),
    home_address varchar(255)  
);

CREATE TABLE people_business_address (
    person_name varchar(255) ,
    home_address varchar(255),
    date_of_birth varchar(255),
    business_name varchar(255),
    business_address varchar(255), 
    id bigint PRIMARY KEY AUTO_INCREMENT	  
);


CREATE TABLE people_mobile (
    forenames varchar(255),
    surname varchar(255),
    date_of_birth varchar(255),
    address varchar(255),
    town varchar(255),
    postcode varchar(255),
    phone_number varchar(255) PRIMARY KEY,
    network varchar(255)  
);


CREATE TABLE vehicle_registration (
    registration_id bigint PRIMARY KEY,
    registration_date varchar(255),
    vehicle_registration_no varchar(255),
    make varchar(255),
    model varchar(255),  
    colour varchar(255),
    forenames varchar(255),	  
    surname varchar(255),
    address varchar(255),	  
    date_of_birth varchar(255),
    driver_licence_id varchar(255)	  
);




