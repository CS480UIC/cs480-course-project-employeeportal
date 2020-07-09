--CREATE DATABASE bookstore;
--
--
--use  bookstore;
--
--CREATE TABLE tb_user 
--(
--  
--  username VARCHAR(50) primary key,
--  `password` VARCHAR(50) NOT NULL,
--  email VARCHAR(50) NOT NULL
--);


CREATE DATABASE EmployeePortal;
use EmployeePortal;

CREATE TABLE portal_Managers(
	ClientID int(20) not null,
	ClinetLoginID varchar(50) not null,
	ClientPassword varchar(50) not null,
	WorkerID int(20) not null,
	WorkerLoginID varchar(50) not null,
	WorkerPassword varchar(50) not null,
	primary key(ClientID, WorkerID)
);

CREATE TABLE Workers(
	WorkerID int(20) primary key,
	Name varchar(50) not null,
	Age int(10),
	Email varchar(50) not null,
	WorkerType varchar(50) not null,
	Skill varchar(50) not null,
	SalaryRange int(20),
	Reviews varchar(500)
);

CREATE TABLE Clients(
	ClientID int(20) primary key,
	Name varchar(50) not null,
	Background varchar(50) not null,
	RequiredWorkerType varchar(50),
	SalaryAfforded int(20),
	NoofDays int(20),
	Workload int(20)
);


