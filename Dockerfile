FROM openjdk:8-jdk-alpine
# add path_fuente path_destino_container
#ADD target/api-0.0.1-SNAPSHOT.jar /my-app/api-sicos.jar  
ADD ./ /my-app/spring-boot/
RUN apk update
RUN apk add maven
RUN apk add vim
# directorio de trabajo en adelante -> cd /my-app/spring-boot/
WORKDIR /my-app/spring-boot/  
#RUN mvn package   #compila y genera el archivo .jar
#ENTRYPOINT [ "java", "-jar", "/my-app/spring-boot/target/api-0.0.1-SNAPSHOT.jar" ]   #ejecuta java -jar path/file.jar
ENTRYPOINT [ "mvn", "spring-boot:run" ]
# docker build -t api-sicos . (. indica donde se encuentra el dockerfile)
