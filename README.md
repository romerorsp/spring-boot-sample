# spring-boot-sample
Sample (empty) spring-boot-application

Scaffold Maven project with spring-boot. Included BOWER configuration for AngularJS and Bootstrap. Just run the following command on the base folder of the application.

    bower install

## Proposed Exercise:
Write a set of REST services with two endpoints:

* GET service to *retrieve* the Greeting Message of the Day
* POST service to *change* the current Greeting Message.

Observations:
* The Greeting Message should be a Spring Bean.
* The Greeting Message could be stored on memory. It can be a Singleton. 
* The application should be self-contained
* The application *SHOULD NOT* use WEB.XML or any spring XML configuration.

### Challenge 1:
Use JERSEY instead of Spring Web

### Challenge 2:
Write a set of JUNIT Tests to test the endpoints.

### Challenge 3:
Write an Angular Application to show the current Greeting Message, and a form to change it. Bonus points if using IIFE. 
Extra-bonus points for using one-way binding when showing the Greeting Message.


##Install and Run
You can run "mvn package" to have the application self-contained and ready to be run as a jar file
After packaging you can run "java -jar target/greet-server.jar" in order to launch the server (make sure the 8090 port is not busy before running it)
Then you can access the application through the URL: http://hostName:8090/ and play some greetings
You can also access the REST services directly through the URL http://hostName:8090/greet

Enjoy it =)
