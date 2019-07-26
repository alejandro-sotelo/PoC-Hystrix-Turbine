FROM openjdk:8-jre-alpine
LABEL Description = "Spring boot chasis microservice"\
      Version = "1.0.0"\
      maintainer.one = "Alejandro Sotelo, alejandrosotelo.ie@gmail.com"

COPY build/docker/lib/ /app/BOOT-INF/lib/
COPY build/docker/app/ /app/

RUN mkdir /log/ \
    && adduser -D appUser -s /bin/sh \
    && chown -R appUser app/ \
    && chown -R appUser log/

USER appUser

CMD java -cp /app/ org.springframework.boot.loader.JarLauncher

EXPOSE 8080
