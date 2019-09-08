FROM tomcat:8.0-alpine
LABEL maintainer="omar.rosadio@unmsm.edu.pe"
USER root
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
ADD SistemaGestionNegocio.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]