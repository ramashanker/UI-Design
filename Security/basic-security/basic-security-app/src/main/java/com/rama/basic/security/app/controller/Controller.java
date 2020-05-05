package com.rama.basic.security.app.controller;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		return "Authenticated";
	}

	
	@RequestMapping(value = "/greetname", method = RequestMethod.GET)
	@ResponseBody
	public String userName(@RequestParam String name /*@PathParam("name") String name*/) {
		return "Hello "+name;
	}
	
	@RequestMapping(value = "/user-name", method = RequestMethod.GET)
	@ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @RequestMapping(value = "/admin-name", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}

