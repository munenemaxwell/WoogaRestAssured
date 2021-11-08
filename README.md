# WoogaRestAssured
Test automation of https://petstore3.swagger.io/api/v3/pet/findByStatus as part of Wooga interview task. <br/>
Test Automation Framework.<br/> 
This assignment has been done using the following tools. <br/>
    1.Rest Assured framework.   <br/>
    2.Junit 5. <br/>
    3.Jacoco for utility functions unit test code coverage measurement. <br/>
    4.Docker to facilitate executing the tests with minimal dependecies.<br/>
    
Requirements to execute. <br/>
    1.Docker. <br/>
    2.Git.   <br/> 

How to execute. <br/>
    1.Clone the repository by running "git clone git@github.com:munenemaxwell/WoogaRestAssured.git && cd WoogaRestAssure " <br/> 
    2.Build an image using the Dockerfile.Run "docker build -t woogaassignment:v1 . "  <br/>        
    3.Run the image to execute the API tests.Use the command "docker run --name woogatask -v jacocoreport:/home/app/target/site wooga:v1".This will run both the unit & API tests & create a volume where you can view the code coverage report. <br/>
    4.To view the code coverage report navigate to target/site/jacoco and open index.html with a browser. <br/>
    
Composition. <br/>
    1.Utility functions are contained in the source folder src/main/java/.<br/>
    2.Entities to represent a pet are contained in the source folder under src/java/entities. <br/>
    3.Unit tests for the utitlity functions are contained in src/test/java/unitTests.Jacoco is used to measure code coverage.<br/>
    

Next Steps.<br/>
    1.Given time, I would improve the assoignment by adding continuous testing integration.<br/>
    
 
 
   
    

