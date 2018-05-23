##  HvA PC :: Assignment 3
This is a warm-up exercise for the configuration of the Rasperry PI cluster.

## Prerequisites
You must have an IDE to work with this project. We recommend using the IntelliJ IDEA Community Edition. This IDE has good integration with Maven and JUnit.

https://www.jetbrains.com/idea/download/#section=mac

### Installation & Configuration

Download or clone this project and open it using your IDE

### Exercise

This project will create two executable jars in the **target** folder:

* **rmi-server.jar**: will start a small chat server. This server simply receives messages from one client and broadcast the received to all registered clients using callback.
* **rmi-client.jar**: will start a small chat client that sends messages to the server. Note that this client is also a remote object that can be called by the server.

To prepare your project to run in your Raspberry PI cluster, make sure that you change the server address and port to use one of the nodes. You will find a configuration file called **resources/config.properties**. 

To generate these jars, simply execute ``mvn clean package`` from the console or use your IDE to run these Maven goals. 
