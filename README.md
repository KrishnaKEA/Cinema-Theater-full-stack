<<<<<<< HEAD
# springboot-movies-rest-api
Spring Boot REST API for other applications in our company. (Bearing in mind that this branch mainly deal with Movies which was the task assigned as the 3rd API in the User Stories provided by PO)

To replicate this back-end application in your local environment:

1) - Make sure to install the following softwares mentioned below:

Java SE Development Kit 11: https://www.oracle.com/java/technologies/downloads/#java11

Apache Maven: https://maven.apache.org/download.cgi

IntelliJ Idea Ultimate IDE: https://www.jetbrains.com/idea/download/#section=windows (note: this is a paid version, however you can use the free Community version with limited capability though)


2) - MySQL Server is essential to perform the database operations.

3) - Clone the repository to your local workspace

4) - Import the project to your IntelliJ IDE

5) - Update the application.properties file with the SQL Database information according to your environment.

6) - I hard coded some dummy data, in my case 3 kind of Movies, by using the 'CommandLine Runner' in the Main class.

7) - Open command prompt in the project folder and run the following command mentioned below to start the REST API:

  mvn spring-boot:run

8) - Now, let's test it using 'Postman' or 'Browser' and visit:
    
      http://localhost:8082/movies           ==> API to get all the movies
    
      http://localhost:8082/movies/id        ==> API to get a specific movie by id

      http://localhost:8082/movies/new       ==> API to add a new Movie

      http://localhost:8082/movies/update/id ==> API to update/edit Movie by id

      http://localhost:8082/movies/delete/id ==> API to delete specific movie by id

Lastly, any wrong fetching / editing by id will normally throw exception.
Although, Spring will throw its default one if one is not provided.
Here we have made our Customer exception handling for movies namely 'MovieNotFoundException' which will return 'Timestamp (Date & time)', 'message (i.e. custom msg)' and 'path (uri)'.

For testing, try with an id that does not exist in our database:  http://localhost:8082/api/movies/55 

=======
# cinema-app by KODAK

|  Name | gh  
|---|---|
|Adrian|https://github.com/adrian52x|
|Dom|https://github.com/Sintry1|
|Karo|https://github.com/shpomp|
|Krishna|https://github.com/KrishnaKEA|
|Omar|https://github.com/OmarExpo|


### Adrian
Made an endpoint to let an authenticated USER get a list of free/booked seats for a given cinema hall, date and time

### Dom
Made a description (or better implementation) of how you plan to get the “Movie Info”, demo a proof of concept for how to fetch movie data from an external source

### Karo
Attempted endpoint to let an authenticated USER edit a booking, sprint 2 documentation

### Krishna
Made endpoint to let an authenticated USER create a booking for seats for a specific movie, cinema hall and (start) time, made endpoint to let an authenticated USER cancel/edit a booking

### Omar
Completed missing parts from sprint1, Added link to image(s) to “Get Movie Info”
>>>>>>> c02cfd83718ca8164eb7796cd18402513e8f3605


