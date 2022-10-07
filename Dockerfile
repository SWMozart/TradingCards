FROM openjdk:17

LABEL maintainer="test@neuefische.de"

ADD backend/target/tradinglegendcard.jar tradinglegendcard.jar

CMD [ "sh", "-c", "java -DServer.port=$PORT -jar /tradinglegendcard.jar"]