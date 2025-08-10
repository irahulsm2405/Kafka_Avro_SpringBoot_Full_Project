This is a fully ready to run kafka-springboot project

It includes:

1. A Spring boot kafka producer which is responsible for creating a new employee. And after saving the employee it will send a message to kafka topic "new-employee-created-event"
2. Two Spring boot kafka consumers, one responsible for sending an sms and other for sending an email. Both will read fora message from topic and once they receive a new user, email and phone will be extracted and console will print messages as email and sms sent. (Note: it will not send actual sms or email. Its just for logic purposes)
3. A 3 broker kafka cluster (server-1, server-2, server-3). (Note: We are using kraft servers and not zookeeper)
4. A core project which separates the event logic from producer and consumers so that multiple consumers can use them just by adding a maven dependency. It helps in resuing the code and helps avoid creating same class everytime in every consumer.

To use this application:

1. Kafka server setup: 
- Download the kafka folder normally and place in C drive.
- Navigate to C:\kafka\bin for MAC or C:\kafka\bin\windows for Windows
- Generate uuid: kafka-storage.bat random-uuid
- Format all servers directory: kafka-storage.bat format -t {uuid} -c {server config file path}. 
			    eg: kafka-storage.bat format -t WlnVNqhpRXKzZDstLy-BHA -c C:\kafka\config\kraft\server-1.properties
- Do same for all server files. Once all directories are formatted we can servers.
- Start the servers: kafka-server-start.bat C:\kafka\config\kraft\server-1.properties
- Start all 3 server is separate terminals. Once the first server starts others need to be started within 20 seconds as server-1 will try to connect to server-2 and server-3 as per          configs, if taken more time then server-1 willtomeout and shutdown. (Note: servers need to be up before running our java app else it will timeout and shutdown)

2. Spring boot project:
- Import producer, core and 2 consumers in an ide.
- On core project class: Right click -> Run as -> Maven install
- Run producer as a spring boot app
- Run consumers as a spring boot app

3. Database:
- This project locally uses mySQL server for a local Database.
- Start the server and create a database called employee in the server.
- If the server is not started my-SQL connector will throw exception and application wont start
(Note: This application works even without a database. So if database is not needed, remove all database related configurations and it will still work)

4. Testing
- You can use any API testing app to send a post request. Tool used for this app was Postman.

Once a request is sent, the app will save the Employee details in Database as well as send the event to topic. Email and SMS consumer will read this message and extract data necessary for them and send email or sms.

Tips in case of issues:

1. Kafka issues: delete the topic, stop servers, generate uuid, format directories, delete temp logs and start the servers again.
2. Core project issues: Clean the project and run it as maven install.
3. Spring boot issues: Clean project, update maven and restart apps. Sometimes spring-boot-dev-tools can cause issues so disable it ad then retry.
