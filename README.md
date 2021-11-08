# WoogaRestAssured
Test automation of https://petstore3.swagger.io/api/v3/pet/findByStatus as part of Wooga interview task. 
Test Automation Framework. 
This assignment has been done using the following tools. 
    1.Rest Assured framework.   
    2.Junit 5. 
    3.Jacoco for utility functions unit test code coverage measurement. 
    4.Docker to facilitate executing the tests with minimal dependecies.
    
Requirements to execute. 
    1.Docker. 
    2.Git.    

How to execute. 
    1.Clone the repository by running "git clone git@github.com:munenemaxwell/WoogaRestAssured.git && cd WoogaRestAssure "  
    2.Build an image using the Dockerfile.Run "docker build -t woogaassignment:v1 . "          
    3.Run the image to execute the API tests.Use the command "docker run --name woogatask -v jacocoreport:/home/app/target/site wooga:v1".This will run both the unit & API tests & create a volume where you can view the code coverage report. 
    4.To view the code coverage report navigate to target/site/jacoco and open index.html with a browser. 
    
Composition. 
    1.Utility functions are contained in the source folder src/main/java/.
    2.Entities to represent a pet are contained in the source folder under src/java/entities. 
    3.Unit tests for the utitlity functions are contained in src/test/java/unitTests.Jacoco is used to measure code coverage.
    

Next Steps.
    1.Given time, I would improve the assoignment by adding continuous testing integration.
    
 
 
   
    

