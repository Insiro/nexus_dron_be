FROM ubuntu

ADD ./build/libs/nexus_drone_eureka-0.0.1-SNAPSHOT.jar eureka.jar

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

ENTRYPOINT ["java","-jar","/eureka.jar"]
