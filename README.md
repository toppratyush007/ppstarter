# Pocketpills Backend

### Prerequisites

#### Database

1) Install PostgreSQL.

2) Create a user named _pocketpilluser_:
    >```create role pocketpillsuser with LOGIN PASSWORD 'pocketpills@123';```

3) Create a database named _pocketpillsdb_:
    >```create database pocketpillsdb; ```
    
4) Provide **create db** role to pocketpillsuser:
    >```alter role pocketpillsuser createdb;```
    

You can connect to the database using the following command:
>```psql -h localhost -d pocketpillsdb -U pocketpillsuser```

#### Framework

1) Install Play framework for Java
2) You may want to use Idea IntelliJ for development

 To get this to work, perform the following steps:
 
 1) Import this project as File>New>Project from existing sources
 2) Ensure that **sbt** is selected in the next step under _Import project from external model_
 3) In the next step, ensure that the following two options are selected 
     1) sbt sources
     2) Use sbt shell for build and import
