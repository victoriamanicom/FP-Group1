# FP-Group1 #

# Final Group Project #

Brief
---------------
<img width="100" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298526-66497592-8bfc-498c-ab46-4dad4a207013.png">

Data provider REDSHIFT, who specialises in gathering call records, financial transactions, and ANPR sightings has been contracted by our customer at the National Investigation Unit to provide data relating to a specific scenario given. One of our customer’s investigators has detained a suspect, and the customer needs to know some background context surrounding the suspect, such as their biographical information, associates, financial transactions, and their whereabouts. 
The goal therefore is to create a functionally secure application which enables the client to search through all records of people provided by REDSHIFT, so that any records of information pertaining to a possible suspect are easily accessible in the four key areas specified in the brief. 

#### Requirements ####

The data in citizen.csv folder needs to be displayed in a readable manner for each person. Ideally data will refer to: 
- Phone 
- Bank 
- Vehicle information
- Whereabouts (from ANPR, Cell Tower location, or a bank transaction data), a single location from a single source is sufficient for scenario 1
- Associates (from mobile call records)

Kanban Board
---------------
<img width="400" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135302757-6082d80a-9d1d-4add-bc94-27b15522ea13.PNG">

<img width="400" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135303272-8d923222-8351-448d-897a-789f7bdc5f4b.PNG">

The Kanban board for this project is available here. For the Kanban board Jira software was used and modelled as an Agile Scrum Board. JIRA has been beneficial for our project, by assigning tasks, having a GUI to organise our workflow and keep track of progress.


Network Infrastructure & Database
---------------
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135436469-0f1bd8c7-35bb-4225-856d-d62922d85a45.PNG">


<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298012-3629ce89-4224-43b8-b2f1-23b34584256c.jpg">

The network infrastructure illustrated above utilises many technologies in order to host our data and allow our application to run in the cloud:

#### Jenkins ####

By using Jenkins pipeline we have access to plugins which facilitate continuous delivery (via webhooks), allowing our application to run automatically when commits are made, accompanied by autonomous testing.

#### AWS #### 

The technologies we use from AWS are examples of Infrastructure as a Service (IaaS), where we have the most control and responsibility over the cloud services available to us.

- We are deploying 3 EC2 instances for Jenkins, our Docker Swarm Manager and Docker Swarm Worker nodes
- Amazon RDS Database is being used to host our data for this project
- The route tables indicate how our subnets are connected to the internet via an Internet Gateway and NAT Gateway
- Our Database is within a private subnet
- Our EC2 instances communicate through an NGINX proxy and are in a public subnet
- All of our resources on Amazon are being held within a VPC

#### Docker #### 

Through Docker, our autonomous process builds images of our application and then proceeds to run them on containers. These containers are orchestrated by Docker Swarm, which is controlling 1 manager and 1 worker node.

Backend
---------------

The backend is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the frontend. As well as the database logic, the backend has HTTP requests, and allows the frontend to access the database and work with the data there.

In order for our frontend to receive the required information on the suspect, Our Controller maps our two HTTP GET requests to our services, where our data on the suspects information is mapped to Data Transfer Objects, allowing the frontend to display the correct information. 

#### DTOs ####

Data Transfer Objects are data contracts instructing classes how data should be represented, The benefits of DTOs have been illustrated throughout this project as with large datasets filled with sensitive information you only want to present requested data, the implementation of DTOs allows for custom representation of data decoupled from their entities.

Frontend
---------------

The frontend is developed using the JavaScript framework React. This allowed us to build a component-based frontend and run a single page application, which improves the rendering times in the browser.

Before building, we started out by creating our wireframe for the application - to give us a strong plan to follow and refer back to throughout development. This helped us keep the user interface clean and easy to use, because we already knew where the components should be placed.
It is written in JSX, interlacing JavaScript and HTML together, which is really useful for building reusable components. We utilised routing in this project to make the user experience as seamless as possible.

We also used the react-bootstrap CSS library to style our website, importing only the required components. Using React-Bootstrap meant we could focus on one of our main requirements for this project by making each component user-friendly, and by using the grid system with a series of containers, rows, and columns, we could layout and align our content so it is easy to read for the user.
We chose to use axios, a promise-based HTTP client, to make our HTTP requests because it automatically converts the response to JSON and it has a simple syntax for making requests.

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135436346-e7c32a82-3afb-4781-aaf8-9f626c9e9a00.PNG">
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135436424-57499ec0-f8d6-4fa6-a5bf-91a94f032921.PNG">

Testing
---------------

Extensive backend testing was carried out, including integration testing and Mockito testing on all functionality and methods called in Java. This enabled the functionality in Java to be tested to make sure that there were no possible breaking points in the backend. Frontend testing was carried out in the form of Selenium testing.

Stretch Goals
---------------
To push the project further into scenario 3
To Push the project into scenario 2
To include information on the cell tower location and the ANPR observations to extend the whereabouts of the suspects in scenario 1. 
To include information on history of locations.
