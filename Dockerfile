FROM maven:3.9.9-amazoncorretto-21-alpine AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
RUN mkdir /app
#RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser

COPY env.properties /app/env.properties
COPY --from=build /project/target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar
WORKDIR /app
#RUN chown -R javauser:javauser /app
#USER javauser
CMD "java" "-jar" "-Dspring.profiles.active=production" "backend-0.0.1-SNAPSHOT.jar"