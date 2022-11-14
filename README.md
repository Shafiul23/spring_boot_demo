# Spring boot demo 

Hello! This project was built using Spring Boot, Docker and MongoDB. The aims of the project was to explore using different 
technologies and the benefits that come with them. 

In this demo application, it is possible to create different student objects with properties such as name, email, address, etc.
These get stored into a MongoDB collection (students) within a database (shafiuldb). This list of students can then be accessed via
a browser using localhost which communicates with the application via an api layer and a service layer.

After creating the model for student objects, I used a .yaml file that would create two docker containers (mongodb and mongo-express).
Using application.properties, I was able to connect app to the database. Inside mongo-express, I created a database named shafiuldb
where the students collection would be housed. Next, I inserted some student objects into the database from the application. To build
on this, I made it so that a unique email was required to input a student into the database. 

