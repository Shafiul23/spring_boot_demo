### Developer Log

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
  * Alternatively, by removing the password and not specifying I wanted to be in, the admin database was automatically used.
* Wanted to use a method within the class Optional (found in java.util)
  * ifPresentOrElse() was introduced in java 13
  * Used ifPresent() instead, which is available in java 8.