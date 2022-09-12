FROM openjdk:17-ea-jdk-buster

WORKDIR /usr/share

COPY target/spring-authorizer-0.0.1-SNAPSHOT.jar .

RUN java -XX:+PrintFlagsFinal -version | grep HeapSize

ENTRYPOINT ["/usr/local/openjdk-17/bin/java", "-Xms512M", "-Xmx1536M", "-jar", "/usr/share/spring-authorizer-0.0.1-SNAPSHOT.jar"]