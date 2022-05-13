FROM openjdk:8-jdk-alpine
RUN apk add --no-cache tzdata
ENV TZ Asia/Kuala_Lumpur
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT exec java $JAVA_OPTS -XveBrify:none -Djava.security.egd=file:/dev/./urandom -jar /app.jar