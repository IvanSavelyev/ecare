package ecare.controllers;

import ecare.domain.Tariff;
import ecare.domain.repository.TariffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TariffController {


    private static final Logger logger = LoggerFactory.getLogger(TariffController.class);
    private TariffRepository tariffRepository;

    @Autowired
    public TariffController(TariffRepository tariffRepository) {

        logger.info("Tariff Controller creating");
        this.tariffRepository = tariffRepository;
    }

    @GetMapping("tariffs")
    public String tariffs(Model model){
        logger.info("tariffs method calling");

        List<Tariff> tariffList = tariffRepository.getAllTariffs();
        tariffList.forEach(e->{
            System.out.println(e);
            e.getOptionList().forEach(System.out::println);
        });
        model.addAttribute("tariffs", tariffList);
        return "tariffs";
    }

    @GetMapping("tariff")
    public String getTariffById(@RequestParam Integer id, Model model){
        logger.info("getTariffById method calling");
        Tariff tariff = tariffRepository.getTariffById(id);
        System.out.println(tariff);
        model.addAttribute("tariff", tariff);
        return "tariff";
    }
}
