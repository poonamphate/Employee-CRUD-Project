# Employee-CRUD-Project
Employee management system using Java REST API and HTML,CSS, JQuery

Goal of this project is to implement Employee Management System to achieve following functionality.

Problem Statement:
1.	Design and develop rest api for employee (it should have id, first_name, last_name, email, phone and skill_set attributes) management. It should have the following operations.
a.	Create
b.	Update employee by id
c.	Read all employees
d.	Read employee by id
e.	Delete employee by id
 
2.	You can use relation database or in memory database for data persistence. 
3.	The API should provide xml and json formatted request and response.
4.	Design and develop web UI/interface to list all employees in table format, update and delete a specific employee from the UI.

Approach

I am using following technologies to implement this application.
1.	Frontend:  HTML, CSS, JavaScript, JQuery
2.	Backend: Java with REST Api, Maven
3.	Database: H2 in-memory database
4.	Testing: Postman, web browser 

Front end: As shown in the figure, our web client is an UI application (index.html) that will display list of Employee records, as well as provide an interface to update, delete or add an Employee to the database.

Back end: Upon receiving a http request from web client, web server invokes REST web services which consist of web APIs for handling GET, PUT, POST and DELETE http request.

How to run the application

To run this application, please follow following instructions.

1.	Download the project repository (RESTfulCRUD_Employee) from git
2.	In the eclipse: File  Import  Existing Maven Project  select downloaded repository. Project Directory structure would look like below 
![DirectoryStructure.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/DirectoryStructure.png)
3.	Copy h2 jar to H2 console
4.	Go to http://localhost:8082 and connect to H2 database inserting JDBC URL as jdbc:h2:tcp://localhost:9092/~/mc  click connect
5.	This should display running h2 instance
6.	Go to eclipse  start tomcat server  deploy RESTfulCRUD_Employee app on tomcat server i.e. Right click on RESTfulCRUD_Employee from project explorer  run on server
7.	In the browser, type this URL  http://localhost:8080/RESTfulCRUD_Employee/index.html





