microservices
=============

*Example* applications for JavaOne 2014 talk.
Tested with JDK7.

# Synchronous
## Person
Java application, using Spring Boot. Running on Tomcat.

Usage:
* mvn clean package
* java -jar target/person-0.0.1-SNAPSHOT.jar

Invoke service:
`http://localhost:7890/person?id=2`

Invoke metrics:
`http://localhost:7890/metrics`

## Address
Java application, using DropWizard. Running on Jetty.

Usage:
* mvn clean package
* java -jar target/address-0.0.1-SNAPSHOT.jar server address.yml

Invoke service:
`http://localhost:7891/address?id=3`

Invoke admin pages:
`http://localhost:7892`

Invoke health check:
`http://localhost:7892/healthcheck`

# ASynchronous
Before executing the microservices, start [RabbitMQ](http://www.rabbitmq.com/download.html) :
`sudo rabbitmq-server`

## Person Publisher
Java application, using Spring Boot. Running on Tomcat and RabbitMQ.

Usage:
* mvn clean package
* java -jar target/person-publisher-0.0.1-SNAPSHOT.jar

Send message to queue:
`http://localhost:7893/send`

Add person to repository:
`http://localhost:7893/addperson?id=4&firstName=Luke&lastName=Skywalker&adresId=1`

Adding a person does not send it to queue directly. Use `/send` again.

## Person Listener
Java application, using Spring Boot. Running on Tomcat and RabbitMQ.

Usage:
* mvn clean package
* java -jar target/person-listener-0.0.1-SNAPSHOT.jar

Listener does not need to be explicitly invoked, but will display messages on receival. This can be changed in `PersonListenerController` as it is a `RestController`.

