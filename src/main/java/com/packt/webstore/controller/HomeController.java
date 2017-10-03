package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/welcome/greeting")
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "Welcome to webstore");
		model.addAttribute("tagline", "The on and amazing webstore");
		
		redirectAttributes.addFlashAttribute("greeting", "Welcome to webstore");
		redirectAttributes.addFlashAttribute("tagline", "The on and amazing webstore");
		
		return "welcome";
	}
	
	@RequestMapping("/")
	public String greeting() {
		return "redirect:/welcome/greeting";
	}
	
}
