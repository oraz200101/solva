FROM amazoncorretto:17
VOLUME /tmp
CMD mkdirs /app/files
COPY ./build/libs/currencyLimit-0.0.1-SNAPSHOT.jar /currencyLimit-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "currencyLimit-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080