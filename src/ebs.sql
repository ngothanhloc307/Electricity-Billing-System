DROP DATABASE IF EXISTS ebs;
CREATE DATABASE ebs;

DROP TABLE  IF EXISTS ebs.login;
CREATE TABLE ebs.login (
  id INT NOT NULL AUTO_INCREMENT,
  meter_no VARCHAR(20),
  user_name VARCHAR(255),
  password VARCHAR(255),  
  name varchar(30),
  user_type VARCHAR(20),
  PRIMARY KEY (id)
);


DROP TABLE  IF EXISTS ebs.customer;
CREATE TABLE ebs.customer (
  customer VARCHAR(20),
  meter_no VARCHAR(20),
  address VARCHAR(100),
  city VARCHAR(30),  
  state varchar(30),
  email VARCHAR(40),
  phone VARCHAR(20)
);


DROP TABLE  IF EXISTS ebs.meter_info;
CREATE TABLE ebs.meter_info (
  meter_no VARCHAR(20),
  meter_location VARCHAR(20),
  meter_type VARCHAR(30),
  phase_code VARCHAR(30),  
  bill_type varchar(30),
  days VARCHAR(20)
);

DROP TABLE  IF EXISTS ebs.tax;
CREATE TABLE ebs.tax (
  cost_per_unit VARCHAR(20),
  meter_rent VARCHAR(20),
  service_change VARCHAR(30),
  service_tax VARCHAR(30),  
  cess varchar(30),
  fixed_tax VARCHAR(20)
);

DROP TABLE  IF EXISTS ebs.bill;
CREATE TABLE ebs.bill (
  meter_no VARCHAR(20),
  month VARCHAR(20),
  units VARCHAR(30),
  total_bill VARCHAR(30),
  status VARCHAR(30)
);

