# Developer Log

11/11/22
 * Created demo application and ran it successfully on port 8080.

12/11/22
 * After restarting IDE, application would no longer run: "Port 8080 is already in use." 
   * This was solved by typing `lsof -i -p` into terminal .
   * The second field, or the PID value was copied, then pasted into `kill -15 PID`
   * After this, the application ran successfully.
 * Had an issue with running the .yaml file but after completing the Docker Desktop tutorial, it ran successfully.
 * Mongo database up and running
 * When attempting to connect application to database, there is an authentication error. 

13/11/22
* Solved MongoDB Authentication error. I was receiving the error because I used a password and specified the database I wanted
  * The solution was to create a new user with access to read and write to the admin database
  * Alternatively, by removing the password and not specifying which database I wanted to be in, the admin database was automatically used.
* Application running with no error messages but students are not being added to the database (checked in Mongo Express).
  * There seems to be no id value generating with the object. 
    * Attempted to manually include id but printed object in console still claims id is null.
    * Successfully changed id but student object still not being added to database.
    * Received duplicate object error when using manual id.
      * Added a unique string to the id field in student class every time the JVM is run. 

14/11/22
* Email field within student object now has to be unique to be added to database.
* Wanted to use a method within the class Optional (found in java.util)
  * ifPresentOrElse() was introduced in Java 9
    * Replaced this by using an if else statement with the ifPresent() method instead.
* Created two new classes, StudentService and StudentController.
  * These are the service layer and api layer respectively.
  * Can now view all students on http://localhost:8080/api/v1/students
* Had an issue with not being able to view or delete students collection on mongo-express
  * Solved this by using MongoDB Compass where I could remove the duplicate copies of the first student