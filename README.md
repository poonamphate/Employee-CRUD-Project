# "Employee-CRUD-Project"

## Problem Statement:

1.	Design and develop rest api for employee (it should have id, first_name, last_name, email, phone and skill_set attributes) management. It should have the following operations.
a.	Create
b.	Update employee by id
c.	Read all employees
d.	Read employee by id
e.	Delete employee by id
 
2.	You can use relation database or in memory database for data persistence. 
3.	The API should provide xml and json formatted request and response.
4.	Design and develop web UI/interface to list all employees in table format, update and delete a specific employee from the UI.

## Approach
I am using following technologies to implement this application.
1.	Frontend:  HTML, CSS, JavaScript, JQuery
2.	Backend: Java with REST Api, Maven
3.	Database: H2 in-memory database
4.	Testing: Postman, web browser 

## Hight level architecture
Front end: As shown in the figure, our web client is an UI application (index.html) that will display list of Employee records, as well as provide an interface to update, delete or add an Employee to the database.

Back end: Upon receiving a http request from web client, web server invokes REST web services which consist of web APIs for handling GET, PUT, POST and DELETE http request.

![ProjectArchitechture.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/ProjectArchitechture.png)

## How to run the application

To run this application, please follow following instructions.

1.	Download the project repository (RESTfulCRUD_Employee) from git
2.	In the eclipse: File -> Import -> Existing Maven Project -> select downloaded repository. 
3.  Project Directory structure would look like below 

![DirectoryStructure.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/DirectoryStructure.png)

3.	Copy h2 jar to H2 console as shown below 

![H2Console.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/H2Console.png)

4.	Go to http://localhost:8082 and connect to H2 database inserting JDBC URL as jdbc:h2:tcp://localhost:9092/~/mc -> click connect
5.	This should display running h2 instance

![H2DatabaseRunningInstance.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/H2DatabaseRunningInstance.png)

6.	Go to eclipse -> start tomcat server -> deploy RESTfulCRUD_Employee app on tomcat server i.e. Right click on RESTfulCRUD_Employee -> from project explorer -> run on server
7.	In the browser, type this URL  http://localhost:8080/RESTfulCRUD_Employee/index.html
8.	Index.html will display list of employees stored in database. 

![UI_EmpMgmtSystem.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/UI_EmpMgmtSystem.png)

9.	Deleting an employee should display following screen.

![UI_EmpMgmtSystem_DeletingEmployee1.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/UI_EmpMgmtSystem_DeletingEmployee1.png)

![UI_EmpMgmtSystem_afterDeletingEmp1.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/UI_EmpMgmtSystem_afterDeletingEmp1.png)

10.	Updating an employee would display following screen.

![UI_EmpMgmtSystem_UpdatingEmployee2.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/UI_EmpMgmtSystem_UpdatingEmployee2.png)

![UI_EmpMgmtSystem_AfterUpdatingEmp2.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/UI_EmpMgmtSystem_AfterUpdatingEmp2.png)

# Testing web API through Postman
Please follow below screenshot for testing this application through Postman tool.

## GET request Json

![Postman_GetRequest_Json.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_GetRequest_Json.png)

## GET request Xml

![Postman_GetRequest_Xml.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_GetRequest_Xml.png)

## GET by id request 

![Postman_GetById.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_GetById.png)

## PUT request

![Postman_PutRequest.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_PutRequest.png)

## Post request

![Postman_PostRequest.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_PostRequest.png)

## Delete request

![Postman_DeleteRequest.png](https://github.com/poonamphate/Employee-CRUD-Project/blob/master/Images/Postman_DeleteRequest.png)




