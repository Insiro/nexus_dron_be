FROM ubuntu

ADD ./build/libs/nexus_drone_gateway-0.0.1-SNAPSHOT.jar gateway.jar

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk

ENTRYPOINT ["java","-jar","/gateway.jar"]
