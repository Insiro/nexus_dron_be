FROM ubuntu

ADD ./build/lib/nexus_drone_notice-0.0.1-SNAPSHOT.jar notice.jar

RUN apt-get update
RUN apt-get install openjdk-8-jdk

ENTRYPOINT ["java","-jar","/notice.jar"]
