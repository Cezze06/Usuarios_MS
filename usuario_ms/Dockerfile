#FROM openjdk:17-jdk-slim

#WORKDIR /user_microservice
#COPY target/usuario_ms-0.0.1-SNAPSHOT.jar ./user_ms.jar

#EXPOSE 6000

#ENV DB_URL=jdbc:mysql://usuario_db:3306/usuario_db
#ENV DB_USERNAME=user1
#ENV DB_PASSWORD=1234

#ARG URL=0.0.0.0:6000

#CMD ["java", "-jar", "user_ms.jar"]

FROM openjdk:17-jdk-oracle
VOLUME /tmp
EXPOSE 6000
ARG JAR_FILE=target/usuario_ms-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
