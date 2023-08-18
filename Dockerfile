FROM openjdk:17-jdk-slim



 

COPY target/DoctorRegistrationProfile.jar app1.jar

 


 

CMD ["java", "-jar", "app1.jar"]