FROM openjdk:19-rc-jdk
MAINTAINER baizhi958216
WORKDIR /nahida_project/anime/backend
COPY ./target/Anime-1.1.0-SNAPSHOT.jar .
CMD ["java", "-jar", "Anime-1.1.0-SNAPSHOT.jar"]