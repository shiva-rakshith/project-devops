FROM sunbird/openjdk-java11-alpine:latest
WORKDIR /home
RUN apk update \
    && apk add unzip \
    && mkdir -p /home
COPY ./target/universal/project-devops-1.0-SNAPSHOT.zip /home
RUN unzip /home/project-devops-1.0-SNAPSHOT.zip -d /home
RUN rm /home/project-devops-1.0-SNAPSHOT.zip
EXPOSE 9000
CMD java -cp "/home/project-devops-1.0-SNAPSHOT/conf/:/home/project-devops-1.0-SNAPSHOT/lib/*" play.core.server.ProdServerStart /home/project-devops-1.0-SNAPSHOT