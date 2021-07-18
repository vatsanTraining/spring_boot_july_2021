FROM java:8

WORKDIR /app
COPY . /app

ADD ./target/tour-rest-sql-service.jar tour-rest-sql-service.jar
ENTRYPOINT ["java","-jar","tour-rest-sql-service.jar"]



