FROM amazoncorretto:17-alpine-jdk
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/TeamViewerCodeChallenge=0.0.1-SNAPSHOT.jar /opt/TeamViewerCodeChallenge=0.0.1-SNAPSHOT.jar
ENTRYPOINT exec java $JAVA_OPT -jar TeamViewerCodeChallenge=0.0.1-SNAPSHOT.jar

