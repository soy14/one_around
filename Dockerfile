FROM openjdk:8-jdk

COPY ./demo /demo
WORKDIR /demo

CMD ["./gradlew", "bootRun"]
