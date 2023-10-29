package com.in28minutes.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	/*
	 * private AuthenticationService authenticationService;
	 * 
	 * public LoginController(AuthenticationService authenticationService) {
	 * super(); this.authenticationService = authenticationService; }
	 */

	// private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping(value="/" ,method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		//		logger.debug("Request Param is {}",name);
		//		logger.info("I want this printed at INFO level {}",name);
		//		logger.warn("I want this printed at WARN level {}",name);
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	/*
	 * @RequestMapping(value="login",method = RequestMethod.POST) public String
	 * gotoWelcome(@RequestParam String name, @RequestParam String password,
	 * ModelMap model) {
	 * 
	 * if(authenticationService.authenticate(name, password)) {
	 * 
	 * model.put("name", name); // model.put("password", password);
	 * 
	 * // Authentication return "welcome"; } model.put("errorMsg",
	 * "Invalid credis !"); return "login"; }
	 */

}
