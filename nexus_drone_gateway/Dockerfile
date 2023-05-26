FROM ubuntu

ADD ./build/libs/nexus_drone_gateway-0.0.1-SNAPSHOT.jar gateway.jar

RUN apt-get update
RUN apt-get install openjdk-8-jdk

ENTRYPOINT ["java","-jar","/gateway.jar"]
