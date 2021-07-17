FROM openjdk:11.0.9.1-jre-slim
VOLUME /tmp
EXPOSE 8888
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]