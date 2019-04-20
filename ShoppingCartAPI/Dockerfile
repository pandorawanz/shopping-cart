FROM openjdk:8u212-jdk-stretch
EXPOSE 8080
VOLUME /tmp
ENV BASE_DIR /app
COPY target/ShoppingCart-1.0-SNAPSHOT.jar $BASE_DIR/app.jar
COPY resources $BASE_DIR/resources
WORKDIR $BASE_DIR
ENTRYPOINT ["java", "-jar", "app.jar"]