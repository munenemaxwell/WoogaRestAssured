# Documentation
Test automation of https://petstore3.swagger.io/api/v3/pet/findByStatus as part of Wooga interview task. <br/>
 <br/>
 
**Test Automation Framework**.<br/> 
This assignment has been done using the following tools. <br/>
    1. Rest Assured framework.   <br/>
    2. Junit 5 for unit testing/Test run framework. <br/>
    3. Jacoco for utility functions unit test code coverage measurement. <br/>
    4. Docker to facilitate executing the tests with minimal dependecies.<br/>
    5. Maven as Build/Run tool
    6. Java as main PL
    
 
**Composition.** <br/>
    1. Utility functions are contained in the source folder src/main/java/.<br/>
    2. Entities to represent a pet are contained in the source folder under src/java/entities. <br/>
    3. Unit tests for the utitlity functions are contained in src/test/java/unitTests.Jacoco is used to measure code coverage.<br/>
    4. Integration tests are contained under  src/test/java/pestore
    
**Requirements to execute container .** <br/>
    1. Docker. <br/>
    2. Git.   <br/> 
    
**How to execute(Docker).** <br/>
    1. Clone the repository by running "git clone git@github.com:munenemaxwell/WoogaRestAssured.git && cd WoogaRestAssure " <br/> 
    2. Build an image using the Dockerfile.Run "docker build -t woogaassignment:v1 . "<br/>
    3. Run the image to execute the API tests.Use the command "docker run --name woogatask -v jacocoreport:/app wooga:v1".This will run both the unit & API tests & create a volume where you can view the code coverage report. <br/>
    4. To view the code coverage report navigate to jacocoreport mountpoint and open target/site/jacoco/index.html with a browser. <br/>
    
    
**Requirements to execute source code(Use this if you are having challenges with the docker build & run process above) .** <br/>
    1. Maven . <br/>
    2. Java installed .   <br/> 


**How to execute Source Code.** <br/>
    1. Clone source code  <br/>
    2. Navigate to the root directory where the pom.xml is contained <br/>
    3. Run mvn clean test .This will clean the target directory and rebuild & run both unit tests and the rest assured API tests.A Build success means all tests have passed . <br/>
    4. Navigate to target/site/jacoco/index.html with a browser to have a view of the code coverage report <br/>
    

**Improvements.**<br/>
    1. Improve the assignment by adding continuous testing integration.<br/>
    
 
 
   
    

