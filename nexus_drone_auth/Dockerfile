FROM ubuntu

ADD ./build/libs/nexus_drone_auth-0.0.1-SNAPSHOT.jar auth.jar

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

ENTRYPOINT ["java","-jar","/auth.jar"]
