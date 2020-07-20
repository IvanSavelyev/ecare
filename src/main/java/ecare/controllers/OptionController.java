
/*
package ecare.controllers;
import ecare.domain.repository.OptionRepository;
import ecare.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OptionController {


    private OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/options")
    public String options(Model model){
        model.addAttribute("options", optionService.getAllOptions());
        return "option";
    }


}


 */