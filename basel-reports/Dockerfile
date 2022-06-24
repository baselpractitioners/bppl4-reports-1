FROM maven:latest
WORKDIR /app
COPY . .
RUN mvn install -DskipTests

CMD ["java", "-jar", "target/SACCR_Reporting-0.0.1-SNAPSHOT.jar"]

EXPOSE 5009