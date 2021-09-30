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

#### AWS ####

The technologies we use from AWS are examples of Infrastructure as a Service (IaaS), where we have the most control and responsibility over the cloud services available to us.

- We are deploying 3 EC2 instances for Jenkins, our Docker Swarm Manager and Docker Swarm Worker nodes
- Amazon RDS Database is being used to host our data for this project
- The route tables indicate how our subnets are connected to the internet via an Internet Gateway and NAT Gateway
- Our Application Manager and Worker instance is within a public subnet and communicate through an NGINX proxy
- Our Database is within a private subnet
- All of our resources on AWS are being held within a VPC
 
 This is represented in the network diagram below:

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135297409-b6fef0de-889c-4735-8686-d63a7b21b8c8.jpg">

The network infrastructure illustrated below utilises many technologies in order to host our data and allow our application to run in the cloud:

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298012-3629ce89-4224-43b8-b2f1-23b34584256c.jpg">

For additional security a Bastion Host was used and our IP addresses were assigned to the the Bastion Host's security group. Therefore machines only defined in the security group could connect to the EC2 instances and access the application.

#### Docker #### 

Dockerfiles were created for both the frontend and backend parts of the application before building our docker images for our frontend, backend and database. 
We created a nginx.conf file and another image to create an nginx instance which would allow us to access into our application via the internet using a reverse-proxy.

#### Docker Compose #### 
We installed Docker compose onto our application manager EC2 instance before writing a "docker-compose.yaml" file to allow us to build our images and deploy our containers all from one command.
In an effort to add some security to this file we made sure to use environmental variables to pass any sensitive or changeable information into this file such as passwords, this meant that this information wasn't stored in a file on our EC2 instance.

#### Docker Swarm #### 
We initialised our application manager EC2 instance as our Docker Swarm manager and added our second instance as a worker node before deploying our application in a stack with multiple replicas of each container or both instances.
The two nodes would allow our system to handle larger amounts of traffic without issue and having multiple replicas gave us some redundancy in case we encountered any problems as well as allowing us to keep the application up even during updates.

#### Jenkins ####

Jenkins was installed on a seperate EC2 Instance from the Application Manager instance, the reason for this was due to Jenkins using a lot of RAM when performing it's builds and tests, which would result in additional load to the Application Manager Instance. 
A pipeline job was created which would automate the deployment our application. The job would build the images we had designed earlier, run unit tests of the java running our application, push our up-to-date images to DockerHub and finally deploy our stack to get the application up and running.
The instructions for this Jenkins job are stored in a Jenkinsfile which we created and added to our GitHub repo. The Jenkins job has also been setup to trigger a redeployment whenever the main branch of our GitHub repo is updated. As mentioned earlier the use of replicas in our swarm allows Jenkins to update the replicas one by one so that the application is not taken fully offline.

Backend
---------------

The backend is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the frontend. As well as the database logic, the backend has HTTP requests, and allows the frontend to access the database and work with the data there.

In order for our frontend to receive the required information on the suspect, Our Controller maps our two HTTP GET requests to our services, where our data on the suspects information is mapped to Data Transfer Objects, allowing the frontend to display the correct information. 

#### DTOs ####

Data Transfer Objects are data contracts instructing classes how data should be represented, The benefits of DTOs have been illustrated throughout this project as with large datasets filled with sensitive information you only want to present requested data, the implementation of DTOs allows for custom representation of data decoupled from their entities.

Frontend
---------------

The frontend is powered by HTML, CSS and JavaScript, utilising the Bootstrap Framework to finetune the layout of the webpage using containers, columns, and rows. This allows the search method to be easily implemented and accessible to website users. HTML and CSS have been used to produce the look of the website and JavaScript has been used to get data from the database to populate the elements on the webpage. 

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135296922-6b03bb73-737d-43a2-82ca-65822ab742fd.PNG">
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135296640-1c9cbbf7-1a4a-4fc8-95d5-99164afb4aae.PNG">

Testing
---------------

Extensive backend testing was carried out, including integration testing and Mockito testing on all functionality and methods called in Java. This enabled the functionality in Java to be tested to make sure that there were no possible breaking points in the backend. Frontend testing was carried out in the form of Selenium testing.

Stretch Goals
---------------
To push the project further into scenario 3
To Push the project into scenario 2
To include information on the cell tower location and the ANPR observations to extend the whereabouts of the suspects in scenario 1. 
To include information on history of locations.
