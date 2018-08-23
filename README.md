# Pocketpills Backend

### Prerequisites

#### Cache

1) Install Redis Server
2) Ensure that the server access is password protected.
3) Keep the username as `pocketpills_redis_user` and password as `pocketpills`

#### Framework

1) Install Play framework for Java
2) You may want to use Idea IntelliJ for development

 To get this to work, perform the following steps:
 
 1) Import this project as File>New>Project from existing sources
 2) Ensure that **sbt** is selected in the next step under _Import project from external model_
 3) In the next step, ensure that the following two options are selected 
     1) sbt sources
     2) Use sbt shell for build and import


#### Testing 
To run the test cases, run the following command on the terminal:
>```sbt test```

#### Coverage
It is essential that the code has a good code coverage. To test whether
the code passes the coverage, run
>```sbt jacoco``` 

If the coverage is not met, you will receive an error, the details
of which will be present in a generated report. 