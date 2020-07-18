CREATE DATABASE employeeportal;


use  employeeportal;

CREATE TABLE client 
(
    name VARCHAR(50) NOT NULL,
   `Background` VARCHAR(50) NOT NULL,
    clientid VARCHAR(50) PRIMARY KEY,
	RequiredType VARCHAR(50) NOT NULL,
	WageRange VARCHAR(50) NOT NULL,
	EstimatedWorkdays DATE(6) NOT NULL,
	workload VARCHAR(20) NOT NULL,
	clientcontactno VARCHAR(20) NOT NULL
);


CREATE TABLE manager  
(
  
    Workerloginid VARCHAR(50) NOT NULL,
   `Workerloginpassword` VARCHAR(50) NOT NULL,
    client_login_id VARCHAR(50) PRIMARY KEY,
	client_password VARCHAR(50) NOT NULL,
	worker_id VARCHAR(50) NOT NULL,
	client_id VARCHAR(50) NOT NULL,
	FOREIGN KEY (worker_id,client_id)
);


CREATE TABLE workers 
(
  
    name VARCHAR(50) NOT NULL,
   `Age` INT NOT NULL,
    email VARCHAR(50) NULL,
	Worker_ID VARCHAR(50) PRIMARY KEY,
	Type VARCHAR(50) NOT NULL,
	Skills VARCHAR(50) NOT NULL,
	Rating	 VARCHAR(20) NOT NULL,
	Wages VARCHAR(20) NOT NULL,
	worker_Contact VARCHAR(50) NOT NULL
);
