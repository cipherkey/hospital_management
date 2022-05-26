# hospital_management
In this project we  are using following libaries and framework that require to develope application

1) SpringBoot ---> using sprinboot developing backend  rest-end point
2) Spring Data JPA ---> It is spring specification of springboot , Using  persistant logig can build.
3) Spring-boot-stater-validation ---->  This is liabaries that provided various annotation to validate client request data . 
4) Maven ---> It is build tool to provided proper structure of project and it manage dependancy that required to developing our project .

To Run application using Execuble JAR File 

Step 1 --> First we create executable JAR File using maven command 
            
          -- mvn clean package

Step 2  --> Make sure your pom.xml should contain.

   a. <packaging>jar</packaging>

   b. <plugin>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-maven-plugin</artifactId>
     </plugin>
     
  Step 3 -->    Within the folder target, we have two JAR

        hospital_management-0.0.1-SNAPSHOT.jar   : This is executable JAR
        hospital_management-0.0.1-SNAPSHOT.jar.original  : This is original JAR and not executable. 
        
   Step 4 -->  Run executable JAR as using this command 

       java -jar target/spring-boot-demo-0.0.1-SNAPSHOT.jar
