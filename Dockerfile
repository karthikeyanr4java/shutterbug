FROM openjdk:11
COPY target/shutterbug-*.jar app/service.jar
COPY src/main/resources/*.* resources/
USER 1001
EXPOSE 8001
CMD ["java","-Xms40M","-Xmx1024M","-jar","app/service.jar"]