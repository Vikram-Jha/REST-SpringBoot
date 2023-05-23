# REST-SpringBoot

## How to setup spring boot configuration in VS Code?

Step1: Download VSCODE form offical site ---> Pretty easy no need to do anything special.
Step2: Install Spring Boot Extension Bundle pack form VS Code extensions.
Step3: It can be done in two ways:     
  - Spring Initializer IO: Go to this website and provide configuration of your project.
  - Ctrl + Shift + P: Create java project --> Give the configuration of your project.

## How to give configuration ?

1. Spring: Select spring version(don't select snapshot spring)
2. Project MetaData:
        - Group:         com.example(Let it be)
        - Artifact:     same as name
        - Name:         give name of project(example: EmployeeAPIS)
        - Description:     REST API related to employee details
        - Package name:     leave as its
        - Packaging:     Jar/WAr -> select Jar
3. Dependencies: Spring Web, Spring Data JPA, H2 Database or MySQL Driver, Spring Boot Dev Tools
4. Project: Based on maven
5. Language: Java

Download and unzip the file and open in VS Code. If initialised using VS Code then good to go.

Note: Used H2 Database for to see database schemas in browser a kind of localhost (application properties need configuation related to this)
      We can use MySQL Driver if we are able to use the MySQL WorkBench (application properties need configuation related to this)
      
## What is the H2 Database application.properties?

#changing the Server Port
server.port=8080

#Database configuration : H2Database
spring.datasource.url=jdbc:h2:mem:employeeDB             ---> Instead of employeeDB we can give name of DB
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=vikram                        ---> Provider username
spring.datasource.password=jaiho                         ---> Provide password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

## How to start building the REST APIs?

create 5 folder in the root where your main() method is present:
    - Entity                ---> Inside this create a POJO Class which will eventually define your table in database.
    - controller            ---> All request api like get,put,post & delete are called here.It fetches data from service and give it to user(client)..
    - Repository            ---> We extends JPARepository by our repository to get inbuild method which we can use in serviceImplementation class.
    - Service                ---> Write the interface of all the method which will be required to implement the APIs.
    - serviceImplementation        ---> Write the implementation of method which was written in service interface.
    - Exception                ---> Can be written in case some exception happens with our REST API like 404 Not Found.

## How to start the application and run the program?

Click on play on class which contains the main method.
Go to http://localhost:8080/api/v1/<The api you want to use> in thunder client extension VS Code to see how thing works.
In web visit http://localhost:8080/h2-console to see the hosted SQL Workbench kind of thing.
