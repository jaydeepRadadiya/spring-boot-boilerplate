FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]