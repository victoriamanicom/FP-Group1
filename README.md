

# NSAC 12 - Final Project - National Investigation Unit  #
#### Eva Bullman, Sebastian Hook, Ivan Okpomor, Victoria Manicom, Raihan Patel, Shamshur Rehman ####
 
---------------
### Brief (Scenario 1) ###
---------------
<img width="100" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298526-66497592-8bfc-498c-ab46-4dad4a207013.png">

Data provider REDSHIFT, who specialises in gathering call records, financial transactions, and ANPR sightings has been contracted by our customer at the National Investigation Unit to provide data relating to a specific scenario given. One of our customer’s investigators has detained a suspect, and the customer needs to know some background context surrounding the suspect, such as their biographical information, associates, financial transactions, and their whereabouts. 
The goal therefore is to create a functionally secure application which enables the client to search through all records of people provided by REDSHIFT, so that any records of information pertaining to a possible suspect are easily accessible in the four key areas specified in the brief. 

#### Data Requirements (received from Product Owner) ####

* Basic bio information
* Phone records
* Bank records
* Vehicle records
* Associates (living with, colleagues, mobile contacts)
* Location data


---------------
### Planning and Design ###
---------------
#### Risk Assessment ####
As part of the design phase we generated a risk assessment to analyse potential risks to our project and discussed control measures that we could put in place to mitigate these factors. It influenced our application structure and design, and helped us to prioritise our issue and epics within our Jira board.
![](https://lh3.googleusercontent.com/9TjBxZhS8TsDp-Nm-y3cy6G_jrYh3smhO4w3NZYVBdGiVdSOpKIpmLMuG5AnPRDz029bsNA-bi4MWA4GtCLf7sqfU-J7cxX8dzzxrGWdMBjoGIukwM4mXU8_YpUwA3_0n18fUayvnZQ=s0)

To ensure the risk assessment evolved throughout the project, we included daily reflections. As incidents occurred we adapted our working style to prevent future incidents. For example, to reduce disruption to workflow, we ensured that more than all team members had access to the documentation and were added as contributors to our GitHub repository so that work could continue if a team member lost internet.

![](https://lh4.googleusercontent.com/F-A4GHMVfJ-WLBo0zw7_8sgDGduNbMlqRgirDRVRxQ-3kPYwOCJSoEaM0DOV8p1Wx9eFX10Dkfin-_-C8i2zoBSKEh5yZevU3Txih3kd779blJAfi5ryt0RQrTdW4h0K2W864gkCznI=s0)

Before starting any builds in this project we created a shared Jira board modelled as a Scrum board and set out our epics for the project (Frontend, Backend, AWS, Jenkins, Testing, Admin). We connected our GitHub repository to our Jira board so we could make smart commits throughout the project to keep our progress clear.

![](https://lh4.googleusercontent.com/jMwc5IbMetJLlK-o46CjVOvRMV_BWrLc_gvivrf4VdBHVeXl3qn9CFrqI-t2bNoW8QCTGXKpcnprYZKHMIwINXNmAzIarKlJVSIyAIT1f4BkP0nIbIbfsLno2DAulstxXBuFpA2b=s0)

We prioritised our epics to make sure we were focusing our efforts in the right place and spending appropriate amounts of time on each area. We also created child and linked issues to make sure that we were aware if one part of the project needed to be completed before another. Throughout the project we regularly committed our source code to Git with smart commits for our Jira board, including useful comments to show what update was made with each version.

<img width="400" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135302757-6082d80a-9d1d-4add-bc94-27b15522ea13.PNG">

![](https://lh6.googleusercontent.com/tYggNblL5zYIzcfAS76IIMM10f4vW7H-6HFH5Ud0wR-ZyHBt8kf4JW9r3DRaY1b2VrD8ZTX-3EUZQWT-LpuTPjZWoiCZ4bCjFz8V43h3Nb8ONCk38aLv8-rxWfS0YCAiSQvr8iigA9Q=s0)

We used a feature branch model matched to our Jira sprints to allow us to work on the different areas of our project without disturbing the main source code base. This meant that the main branch never contained broken code, which was advantageous to our continuous integration environment. We implemented branch protection rules to force peer reviews on any pull requests made, ensuring that the updates were correct before approval.

PIC OF NETWORK GRAPH HERE!

---------------
### Network Infrastructure & Database ###
---------------

#### AWS ####

The technologies we use from AWS are examples of Infrastructure as a Service (IaaS), where we have the most control and responsibility over the cloud services available to us.

- We are deploying 3 EC2 instances for Jenkins, our Docker Swarm Manager and Docker Swarm Worker nodes
- Amazon RDS Database is being used to host our data for this project
- The route tables indicate how our subnets are connected to the internet via an Internet Gateway and NAT Gateway
- Our Application Manager and Worker instances are within a public subnet and communicate through an NGINX proxy
- Our Database is within a private subnet
- All of our resources on AWS are being held within a VPC
 
 This is represented in the network diagram below:

![](https://lh5.googleusercontent.com/YVzFClr4k64gYhZj2bdQRpZyiyi6ueowXYovLRpo1q1Uj8-ntnxUHwA8vUr7XIJ-jyEjebeSpF7aNpV1o5wJAWrUMCwVxz6Nma-OA6xo-z4-9wGCpTMdk-6Ga6-KZ7pDfSHKlhYXxAc=s0)

The network infrastructure illustrated below utilises many technologies in order to host our data and allow our application to run in the cloud:

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135298012-3629ce89-4224-43b8-b2f1-23b34584256c.jpg">

For additional security a Bastion Host was used and our IP addresses were assigned to the the Bastion Host's security group. Therefore machines only defined in the security group could connect to the EC2 instances and access the application.

#### RDS ####

As stated earlier, to store the data that was provided we used an Amazon RDS. The reason was due to the RDS being easily available and very durable as it was hosted by AWS themselves. The datafiles were uploaded directly to the Application Manager instance. MySQL was used as the database management system to store the data sets as this was a technology we were comfortable with. Once MySQL was installed and initialised on the instance, the data sets were imported using MySQL import which is a tool that inserts databases into tables using just one command.

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

---------------
### Backend ###
---------------

The backend is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the frontend. As well as the database logic, the backend has HTTP requests, and allows the frontend to access the database and work with the data there.

In order for our frontend to receive the required information on the suspect, Our Controller maps our two HTTP GET requests to our services, where our data on the suspects information is mapped to Data Transfer Objects, allowing the frontend to display the correct information. 

#### DTOs ####

Data Transfer Objects are data contracts instructing classes how data should be represented, The benefits of DTOs have been illustrated throughout this project as with large datasets filled with sensitive information you only want to present requested data, the implementation of DTOs allows for custom representation of data decoupled from their entities.

---------------
### Frontend ###
---------------

The frontend is developed using the JavaScript framework React. This allowed us to build a component-based frontend and run a single page application, which improves the rendering times in the browser.

Before building, we started out by creating our wireframe for the application - to give us a strong plan to follow and refer back to throughout development. This helped us keep the user interface clean and easy to use, because we already knew where the components should be placed.

<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135436346-e7c32a82-3afb-4781-aaf8-9f626c9e9a00.PNG">
<img width="560" alt="Day 2 frontend" src="https://user-images.githubusercontent.com/86114742/135436424-57499ec0-f8d6-4fa6-a5bf-91a94f032921.PNG">
ADD FINAL SCREENSHOT IN HERE
It is written in JSX, interlacing JavaScript and HTML together, which is really useful for building reusable components. We utilised routing in this project to make the user experience as seamless as possible.

#### React-Bootstrap ####
We also used the react-bootstrap CSS library to style our website, importing only the required components. Using React-Bootstrap meant we could focus on one of our main requirements for this project by making each component user-friendly, and by using the grid system with a series of containers, rows, and columns, we could layout and align our content so it is easy to read for the user.

SCREENSHOT OF BOOTSTRAP COMPONENT HERE

#### Axios ####
We chose to use axios, a promise-based HTTP client, to make our HTTP requests because it automatically converts the response to JSON and it has a simple syntax for making requests.
CODE SNIPPET HERE



---------------
### Testing ###
---------------
Our aim for testing was a full test suite covering:

Unit and integration testing for backend

Automation and user acceptance tests for front end

**80% test coverage goal** (*industry standard*)

#### Backend Testing ####
Extensive backend testing was carried out, including integration testing and Mockito testing on all functionality and methods called in Java. This enabled the functionality in Java to be tested to make sure that there were no possible breaking points in the backend. 

#### Frontend Testing ####
Frontend testing was carried out in the form of Selenium testing. ADD MORE DETAIL ABOUT WHAT WE END UP DOING

---------------
### Stretch Goals ###
---------------
* To push the project further into Scenario 3 by including the ANPR observations linked to the suspect's vehicle details to find out their recent vehicle locations.
* To Push the project into Scenario 2 by using cell tower location data, ANPR observations and financial transactions to find out who was in a certain location at given times.
