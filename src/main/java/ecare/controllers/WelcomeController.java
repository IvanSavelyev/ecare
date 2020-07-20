package ecare.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    public WelcomeController() {
        logger.info("Welcome Controller creating");
    }

    @GetMapping("/")
    public String welcome(Model model){
        logger.info("welcome method calling");
        model.addAttribute("greeting","Welcome to eCate telecom company!");
        model.addAttribute("tagline","The most popular provider in North");
        return "welcome";
    }
}
