Requirements

Maven
JDK 9

Configuration

First you need to edit application.properties to config your own db driver.
Then you need to build corresponding schemas in your db.(For me, I privide sql file to build all schemas as jobster.sql)

Running

To build and start the server simply type

$ mvn spring-boot:run
from the root directory.

Using

Browse to localhost:8080 to see the application in action.
