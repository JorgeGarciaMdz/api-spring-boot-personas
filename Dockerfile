FROM openjdk:8-jdk-alpine
# add path_fuente path_destino_container
ADD target/api-0.0.1-SNAPSHOT.jar /my-app/api-sicos.jar  
ENTRYPOINT [ "java", "-jar", "/my-app/api-sicos.jar" ]
# docker build -t api-sicos . (. indica donde se encuentra el dockerfile)
