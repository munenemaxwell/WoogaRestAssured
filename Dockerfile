FROM maven:3.6.0-jdk-11-slim 
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
CMD ["mvn","-f","/app/pom.xml" ,"clean","test"]
VOLUME  ["/app"]

