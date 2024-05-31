DROP TABLE IF EXISTS J_student_child;
DROP TABLE IF EXISTS J_student_order;
DROP TABLE IF EXISTS J_passport_office;
DROP TABLE IF EXISTS J_register_office;
DROP TABLE IF EXISTS J_country_struct;
DROP TABLE IF EXISTS J_street;

CREATE TABLE J_street (
    street_code INTEGER NOT NULL,
    street_name VARCHAR(300),
    PRIMARY KEY (street_code)
);

CREATE TABLE J_country_struct (
    area_id CHAR(12) NOT NULL,
    area_name VARCHAR(200),
    PRIMARY KEY (area_id)
);

CREATE TABLE J_passport_office (
    p_office_id INTEGER NOT NULL,
    p_office_name VARCHAR(200),
    p_office_area_id CHAR(12) NOT NULL,
    PRIMARY KEY (p_office_id),
    FOREIGN KEY (p_office_area_id) REFERENCES J_country_struct (area_id) ON DELETE RESTRICT
);

CREATE TABLE J_register_office (
    r_office_id INTEGER NOT NULL,
    r_office_name VARCHAR(200),
    r_office_area_id CHAR(12) NOT NULL,
    PRIMARY KEY (r_office_id),
    FOREIGN KEY (r_office_area_id) REFERENCES J_country_struct (area_id) ON DELETE RESTRICT
);

CREATE TABLE J_student_order (
    student_order_id SERIAL,
    h_sur_name VARCHAR(100) NOT NULL,
    h_given_name VARCHAR(100) NOT NULL,
    h_patronymic VARCHAR(100) NOT NULL,
    h_date_of_birth DATE NOT NULL,
    h_post_index VARCHAR(10),
    h_street_code INTEGER NOT NULL,
    h_building VARCHAR(10) NOT NULL,
    h_extension VARCHAR(10),
    h_appartment VARCHAR(10),
    h_passport_seria VARCHAR(10) NOT NULL,
    h_passport_number VARCHAR(10) NOT NULL,
    h_passport_date DATE NOT NULL,
    h_passport_office_id INTEGER NOT NULL,

    w_sur_name VARCHAR(100) NOT NULL,
    w_given_name VARCHAR(100) NOT NULL,
    w_patronymic VARCHAR(100) NOT NULL,
    w_date_of_birth DATE NOT NULL,
    w_post_index VARCHAR(10),
    w_street_code INTEGER NOT NULL,
    w_building VARCHAR(10) NOT NULL,
    w_extension VARCHAR(10),
    w_appartment VARCHAR(10),
    w_passport_seria VARCHAR(10) NOT NULL,
    w_passport_number VARCHAR(10) NOT NULL,
    w_passport_date DATE NOT NULL,
    w_passport_office_id INTEGER NOT NULL,

    certificate_id VARCHAR(20) NOT NULL,
    register_office_id INTEGER NOT NULL,
    marriage_date DATE NOT NULL,
    PRIMARY KEY (student_order_id),
    FOREIGN KEY (h_street_code) REFERENCES J_street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (w_street_code) REFERENCES J_street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (register_office_id) REFERENCES J_register_office (r_office_id) ON DELETE RESTRICT
);

CREATE TABLE J_student_child (
    student_child_id SERIAL,
    student_order_id INTEGER NOT NULL,
    c_sur_name VARCHAR(100) NOT NULL,
    c_given_name VARCHAR(100) NOT NULL,
    c_patronymic VARCHAR(100) NOT NULL,
    c_date_of_birth DATE NOT NULL,
    c_post_index VARCHAR(10),
    c_street_code INTEGER NOT NULL,
    c_building VARCHAR(10) NOT NULL,
    c_extension VARCHAR(10),
    c_appartment VARCHAR(10),
    c_certificate_number VARCHAR(10) NOT NULL,
    c_certificate_date DATE NOT NULL,
    c_register_office_id INTEGER NOT NULL,
    PRIMARY KEY (student_child_id),
    FOREIGN KEY (c_street_code) REFERENCES J_street (street_code) ON DELETE RESTRICT,
    FOREIGN KEY (c_register_office_id) REFERENCES J_register_office (r_office_id) ON DELETE RESTRICT
);
