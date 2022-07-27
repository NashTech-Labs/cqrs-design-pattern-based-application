 FROM openjdk:11
 ARG JAR_FILE=target/axon-0.0.1.jar
 ADD  ${JAR_FILE} /axon-0.0.1.jar
 ENTRYPOINT exec java -jar axon-0.0.1.jar
