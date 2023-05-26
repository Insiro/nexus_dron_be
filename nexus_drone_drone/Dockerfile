FROM ubuntu

ADD ./build/lib/nexus_drone_drone-0.0.1-SNAPSHOT.jar drone.jar

RUN apt-get update
RUN apt-get install openjdk-8-jdk

ENTRYPOINT ["java","-jar","/drone.jar"]
