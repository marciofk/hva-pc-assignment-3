##  HvA PC :: Assignment 3
This is a warm-up exercise for the configuration of the Rasperry PI cluster.

## Prerequisites
You must have an IDE to work with this project. We recommend using the IntelliJ IDEA Community Edition. This IDE has good integration with Maven and JUnit.

https://www.jetbrains.com/idea/download/#section=mac

### Installation & Configuration

Download or clone this project and open it using your IDE

### Exercise

#### Project packaging

This project will create two executable jars in the **target** folder:

* **rmi-server.jar**: will start a small chat server. This server simply receives messages from one client and broadcast the received to all registered clients using callback.
* **rmi-client.jar [host] [port]**: will start a small chat client that connects to the RMI server address at [host:port], retrieve the remote object for the server, and sends messages. Note that this client is also a remote object that can be called by the server whenever the server has new messages to send. The parameters **host** and **port** are optional and you can change the default values by using the configuration file  **resources/config.properties**. 

To generate these jars, simply execute ``mvn clean package`` from the console or use your IDE to run these Maven goals. You can copy these jars to the hosts of your Raspberry PI cluster.

#### Running the app

* Start one the server by calling ``java -jar rmi-server.jar`` in your hist
* Start one or more clients by calling ``java -jar rmi-server.jar [host] [port]``, where [host] and test the application, by typing messages

d) Check the server and client logs


