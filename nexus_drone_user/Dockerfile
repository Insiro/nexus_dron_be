FROM ubuntu

ADD ./build/libs/nexus_drone_user-0.0.1-SNAPSHOT.jar user.jar

RUN apt-get update
RUN apt-get install -y openjdk-8-jdk

ENTRYPOINT ["java","-jar","/user.jar"]
