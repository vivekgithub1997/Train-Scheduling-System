# Train Scheduling System Backend

This project implements a backend system for a train scheduling application using Java Spring Boot.

## Overview

The backend provides APIs to perform CRUD operations on trains and retrieve trains between given source and destination stations.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit  and Mockito (for unit testing)

  
  ## Steps to run this project
   - first clone the repository to the local system then open any IDE.
   - import(MAVEN import ) this project to IDE.

   - click the project and go to the run as >> spring boot app
   - this project running on port number 9090
   - after running this project go to the browser and paste this URL <http://localhost:9090/swagger-ui/index.html> see the screenshots of all the API
     # 

    # Let's assume you have the following endpoints in your train scheduling system:

    # Add Train:
       - Method: POST
          URL: http://localhost:9090/train/savetrain
          Request Body (JSON):
           {
                  "trainName": "Taj Express",
                  "trainStations": ["chitrakoot","agra","new delhi"
                    ]
           }
   # Get All Trains:
      - Method: GET
      URL: http://localhost:9090/train/alltrains
  
   # Delete Train:
     - Method: DELETE
      URL: http://localhost:9090/train/1
     (Assuming you want to delete train with ID 1)

   # Update Train:
     - Method: PUT
       URL: http://localhost:9090/train/1
       Request Body (JSON) - Updated Train Details:
        {
  
                "trainName": "Taj Express",
               "trainStations": ["chitrakoot","agra","mathura,"new delhi"
               ]
      }

   # Get Trains Between Stations:
     - Method: GET
       URL: http://localhost:9090/train/sourceStation /destinationStation
       

    # How to access database
     - URL: http://localhost:9090/h2-console 

                                   ## THANK YOU :) ##
