# README #

This README would normally document whatever steps are necessary to get ContactManagementSystem application up and running.

# Quick Summary #
	
Contact Management System is a web application to manage the contact details of registered users.

# Technologies Used #

Angular JS
Spring Boot - 1.2.2.RELEASE
Java 1.7
MongoDB 2.6
Tomcat 7

# Steps to build the project #

 - Unzip the ContactManagementSystem.zip file attached
 - Open command prompt, change the location to ContactManagementSystem
 - run the command "mvn clean install", this will generate CMS.war file in ContactManagementSystem\target\ folder
 - Copy the CMS.war file to webapps folder in Tomcat installation folder
 - Start MongoDB database 
 - Start Tomcat server
 - The application will be available at http://localhost:8080/CMS/
 
# Additional configuration for automatic deployment to Tomcat Server #
 
  - Modify the pom.xml to and add Tomcat plugin for deployment as given below
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<url>http://localhost:8080/manager/text</url>
					<server>TomcatServer</server>
					<username>admin</username>
		                	<password>password</password>
					<path>/CMS</path>
				</configuration>
			</plugin>
			
 - Add manager-gui and manager-script roles in tomcat-users.xml ($TOMCAT_HOME/conf/)
			<role rolename="manager-gui"/>
			<role rolename="manager-script"/>
			<user username="admin" password="password" roles="manager-gui,manager-script" />
			
 - Update maven settings.xml ($MAVEN-HOME/conf/) to include tomcat server deployment end point as given below 
			<server>
				<id>TomcatServer</id>
				<username>admin</username>
				<password>password</password>
			</server>
			
- Start the Tomcat server
			
- Run the command "mvn clean package tomcat7:redeploy" to build and deploy the application to Tomcat server 


 
