FROM ubuntu

ADD ./build/libs/nexus_drone_drone-0.0.1-SNAPSHOT.jar drone.jar

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk

ENTRYPOINT ["java","-jar","/drone.jar"]
