# Contacts
This project is a combination of three sub-projects
Sub projects: 
  - contacts 
  - contacts-maven
  - contacts-security
  
## 1. contacts
This project gives a deep understanding of:
  - JSP, Servlet
  - MySql
  - MCV architecture
  - custom security
  - Log4j
  - Utils: FileUtils, DatabaseUtils
  - resource injection

## 2. contacts-maven
This project gives a deep understanding of a) maven project structure and b) auto deployment.
Note: Before deploying using 'mvn tomcat7:deploy' start the tomcat server.
Useful links: [Auto deploy] (http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/)

## 3. contacts-security
This project gives a deep understanding of JEE Container Managed Security.

###### Steps to note:
```
  - Mention the realm name in tomcat/config/server.xml
  - Configure 'web-constraint', 'login-config' 'security-role'and 'error-page' elements in web.xml
  - Create login page with j_security_check, j_username, j_password
  - create two mysql tables users and user_roles (search online on how to create tables properly)
  - use String username = request.getRemoteUser() to get ther current username 
```
Useful links: [Container Security vs Custom Security](https://www.javaworld.com/article/2072850/java-security/j2ee-security--container-versus-custom.html), [Tomcat Realm](https://javapipe.com/hosting/blog/tomcat-realm/)   
