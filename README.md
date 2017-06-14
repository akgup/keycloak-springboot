# keycloak-springboot
This project is showing how we can integrate springboot application with Keycloak Server. Operations like creating user in kecyloak, authenticating http api request, getting access token using credentials or refreshtoken, logout user. 

## Components Version ##
* Java 1.8
* Maven 3.x
* Springboot 1.5.4
* Keycloak 3.1.0.Final

## Pre-requisities
* Kyecloak Installation

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
 
