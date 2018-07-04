-- drop the existing database
drop database carter;

-- create the test user
create user test password 'test';

-- create the database
create database carter owner test;
