
FROM tomcat:9.0
LABEL maintainer="msxclaropijo@hotmail.com"
WORKDIR /usr/local/tomcat
CMD ["catalina.sh", "run"]
COPY target/MSXToolsWeb-1.war /usr/local/tomcat/webapps/MSXToolsWeb.war


#docker build -t mytomcat .
#docker run --rm -d -p 8080:8080 --name tomcat-container mytomcat
#docker run --rm -d -p 8080:8080 --name tomcat-container -v C:/Users/casa/Desktop/netbeans-proyects/HolaMundo/target:/usr/local/tomcat/webapps mytomcat
#docker exec -it tomcat-container /bin/bash


