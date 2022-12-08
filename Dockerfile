FROM openjdk:19-rc-jdk
MAINTAINER baizhi958216
WORKDIR /nahida_project/anime/backend
COPY ./target/Anime-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "Anime-0.0.1-SNAPSHOT.jar"]