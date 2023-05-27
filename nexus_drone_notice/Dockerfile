FROM ubuntu

ADD ./build/libs/nexus_drone_notice-0.0.1-SNAPSHOT.jar notice.jar

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk

ENTRYPOINT ["java","-jar","/notice.jar"]
