# FP-Group1 #

# Final Group Project #

Brief
---------------
<img width="100" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298526-66497592-8bfc-498c-ab46-4dad4a207013.png">

Data provider REDSHIFT, who specialises in gathering call records, financial transactions, and ANPR sightings has been contracted by our customer at the National Investigation Unit to provide data relating to a specific scenario given. One of our customer’s investigators has detained a suspect, and the customer needs to know some background context surrounding the suspect, such as their biographical information, associates, financial transactions, and their whereabouts. 
The goal therefore is to create a functionally secure application which enables the client to search through all records of people provided by REDSHIFT, so that any records of information pertaining to a possible suspect are easily accessible in the four key areas specified in the brief. 

Kanban Board
---------------
The Kanban board for this project is available here. For the Kanban board Jira software was used and modelled as an Agile Scrum Board. 
Jira board presentation
Example of a user story


Database
---------------
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135297409-b6fef0de-889c-4735-8686-d63a7b21b8c8.jpg">


<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298012-3629ce89-4224-43b8-b2f1-23b34584256c.jpg">
The database utilises many technologies in order to host our data and allow our application to run in the cloud:

•	Jenkins: By using Jenkins pipeline we have access to plugins which facilitate continuous delivery (via webhooks), allowing our application to run automatically when commits are made, accompanied by autonomous testing.

•	AWS: The technologies we use from AWS are examples of Infrastructure as a Service (IaaS), where we have the most control and responsibility over the cloud services available to us.


•	Docker: Through docker, our autonomous process builds images of our flask app and then proceeds to run them on containers. These containers are orchestrated by Docker Swarm, which controls x Manager and x Worker nodes.

Backend
---------------

The backend is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the frontend. As well as the database logic, the backend has HTTP requests, and allows the frontend to access the database and work with the data there. 

Frontend
---------------

The frontend is powered by HTML, CSS and JavaScript, utilising the Bootstrap Framework to finetune the layout of the webpage using containers, columns, and rows. This allows the search method to be easily implemented and accessible to website users. HTML and CSS have been used to produce the look of the website and JavaScript has been used to get data from the database to populate the elements on the webpage. 
Screenshots of the final frontend homepage
Of it searching for someone
For each of the tabs for a person

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135296922-6b03bb73-737d-43a2-82ca-65822ab742fd.PNG">
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135296640-1c9cbbf7-1a4a-4fc8-95d5-99164afb4aae.PNG">

Testing
---------------

Extensive backend testing was carried out, including integration testing and Mockito testing on all functionality and methods called in Java. This enabled the functionality in Java to be tested to make sure that there were no possible breaking points in the backend. Frontend testing was carried out in the form of Selenium testing. SELENIUM

Stretch Goals
---------------
To push the project further into scenario 3
To Push the project into scenario 2
To include information on the cell tower location and the ANPR observations to extend the whereabouts of the suspects in scenario 1. 

