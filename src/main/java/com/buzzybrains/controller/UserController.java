package com.buzzybrains.controller;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.buzzybrains.services.KeyCloakService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	KeyCloakService keyCloakService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> sayHello() {

		return new ResponseEntity<>("Hi!, you are auhorized to view this response!", HttpStatus.OK);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<?> logoutUser(HttpServletRequest request) {

		request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		AccessToken token = ((KeycloakPrincipal<?>) request.getUserPrincipal()).getKeycloakSecurityContext().getToken();

		String userId = token.getSubject();

		keyCloakService.logoutUser(userId);

		return new ResponseEntity<>("Hi!, you have logged out successfully!", HttpStatus.OK);

	}

	@RequestMapping(value = "/update/password", method = RequestMethod.GET)
	public ResponseEntity<?> updatePassword(HttpServletRequest request, String newPassword) {

		request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		AccessToken token = ((KeycloakPrincipal<?>) request.getUserPrincipal()).getKeycloakSecurityContext().getToken();

		String userId = token.getSubject();

		keyCloakService.resetPassword(newPassword, userId);

		return new ResponseEntity<>("Hi!, your password has been successfully updated!", HttpStatus.OK);

	}

}
