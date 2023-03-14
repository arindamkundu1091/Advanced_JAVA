package org.study;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/disp")
	public String disp(HttpServletRequest request, Model m) {
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		if(email.equals("admin@gmail.com") && pass.equals("admin")) {
			String msg = "Welcome! "+email;
			m.addAttribute("id", msg);
			return "success";
		}else {
			String msg = "Error! "+email+" or "+pass+" is invalid.";
			m.addAttribute("id2", msg);
			return "error";
		}
	}
}
