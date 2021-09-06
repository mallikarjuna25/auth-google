package com.brillio.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class AuthGoogleApplication {

//	@GetMapping("/")
//	public String welcome() {
//		return "welcome";
//	}
		@GetMapping("/")
	public String user(@AuthenticationPrincipal OAuth2User principal){
		List<String> a= new ArrayList<>();
		a.add(principal.getAttribute("name"));

		String value="";
		for (String s: a) {
			value=s;
		}
		return  "welcome to "+" "+value;
	}

	@GetMapping("/user_all")
	public Principal user(Principal principal) {
		System.out.println("username :"+principal.getName());
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthGoogleApplication.class, args);
	}

}
