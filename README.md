# keycloak-springboot 11
This project is showing how we can integrate springboot application with Keycloak Server. Operations like creating user in kecyloak, authenticating http api request, getting access token using credentials or refreshtoken, logout user. 

## Components Version ##
* Java 1.8
* Maven 3.x
* Springboot 1.5.4
* Keycloak 3.1.0.Final

## Pre-requisities
* Kyecloak Server is up and running

## Change in application.properties
```
keycloak.realm = demo <Replace with your realm name>
keycloak.auth-server-url = http://127.0.0.1:8080/auth  <Remain same>
keycloak.resource = service <Replace with created client name>

#replace secret with your key
keycloak.credentials.secret =XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  <Replace with created secret key>
keycloak.bearer-only = true
 
keycloak.securityConstraints[1].authRoles[0] = user
keycloak.securityConstraints[1].securityCollections[0].name = user
keycloak.securityConstraints[1].securityCollections[0].patterns[0] = /user/*

```
## Running application
run from below from command line
```
mvn spring-boot:run
```
## Test Application
* First Create user using "/keycloak/create" rest service. Where pass user details like username,email,password, firstname, lastname etc. 
* Now by call "/keycloak/token" with user credentials. Server validate it and give response with access_token and refresh_token. 
* Use access token to access "user/hello" pass it in header as Authorization: bearer <access_token>
* I am attaching postman json file also.
 
