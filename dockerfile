
FROM tomcat:9.0
LABEL maintainer="msxclaropijo@hotmail.com"
WORKDIR /usr/local/tomcat
CMD ["catalina.sh", "run"]
COPY MSXToolsWeb-1.war /usr/local/tomcat/webapps/MSXToolsWeb.war

#1 Cambia el directorio de la clase C:\Users\casa\Desktop\netbeans-proyects\MSXToolsWeb\src\main\java\utils\Constants.java y adaptalo a linux
#2 mvn clean
#3 mvn package
#4 copia el wr que te ha metido en C:\apache-tomcat-9.0.78\webapps y pégalo en la raiz de este proyecto
#5 docker build -t mytomcat .
#6 docker run --rm -d -p 8080:8080 --name tomcat-container mytomcat
#7 ve a http://localhost:8080/MSXToolsWeb/index.html
#docker run --rm -d -p 8080:8080 --name tomcat-container -v C:/Users/casa/Desktop/netbeans-proyects/HolaMundo/target:/usr/local/tomcat/webapps mytomcat

#10 Puedes meterte dentro de la máquina con:
    #docker exec -it tomcat-container /bin/bash

#Borra con:
    #docker stop tomcat-container
    #docker image rm mytomcat
#Sube a github y render.com con:
    #mvn clean
    #git add .
    #git commit -m "nuevo commit"
    #git push origin main


