package org.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("welcome")
	public String Welcome() {
		return "welcome.html";
	}
}
