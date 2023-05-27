FROM ubuntu

ADD ./nexus_drone_eureka/build/lib/nexus_drone_eureka-0.0.1-SNAPSHOT.jar eureka.jar

RUN apt-get update
RUN apt-get install openjdk-8-jdk

ENTRYPOINT ["java","-jar","/eureka.jar"]
