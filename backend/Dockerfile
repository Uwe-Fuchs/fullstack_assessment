# docker build -t japp .
# docker run -p 8090:8090 --name assessment japp
# docker run -p 8090:8090 -d --name assessment japp

FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/assecor-assessment-0.0.1-SNAPSHOT.jar
RUN mkdir /opt/app
COPY build/libs/assecor-assessment-0.0.1-SNAPSHOT.jar /opt/app
COPY sample-input.csv /data/
ENV DATA_FILE_PATH=/data/sample-input.csv
CMD ["java", "-jar", "/opt/app/assecor-assessment-0.0.1-SNAPSHOT.jar"]
