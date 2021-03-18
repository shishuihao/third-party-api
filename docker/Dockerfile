FROM openjdk:8-jdk
MAINTAINER "shishuihao <1285173409@qq.com>"
LABEL description="third-party-api"

ARG VERSION

WORKDIR third-party-api
ADD third-party-api-${VERSION}.jar /third-party-api/third-party-api.jar

EXPOSE 8080

CMD java -jar /third-party-api/third-party-api.jar