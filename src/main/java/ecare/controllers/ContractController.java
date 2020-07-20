package ecare.controllers;

import ecare.domain.Contract;
import ecare.domain.repository.ContractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContractController {

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);
    private ContractRepository contractRepository;

    @Autowired
    public ContractController(ContractRepository contractRepository) {
        logger.info("Contract Controller creating");
        this.contractRepository = contractRepository;
    }


    @GetMapping("/contracts")
    public String showContract(Model model){
        logger.info("showContract method calling");
        List<Contract> contractList = contractRepository.showContract();
        contractList.forEach(e->{
            System.out.println(e);
            System.out.println(e.getTariff());
            //e.getOptionList().forEach(System.out::println);
        });
        model.addAttribute("contracts", contractList);
        return "contract";
    }
}
