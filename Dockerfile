FROM maven:3.8.5-openjdk-17

COPY settings.xml /root/.m2/settings.xml

WORKDIR /app

COPY . /app
RUN mvn package

EXPOSE 1314

CMD ["java", "-jar", "./target/Anime-1.1.0-SNAPSHOT.jar"]