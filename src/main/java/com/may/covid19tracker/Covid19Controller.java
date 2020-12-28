package com.may.covid19tracker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class Covid19Controller {

    private final CovidDataService covidDataService;

    @GetMapping("/korea")
    public String getKoreaDatas(Model model) throws IOException {
        List<KoreaCovidInfo> list = covidDataService.getCovidDatas();

        model.addAttribute("korea", covidDataService.getCovidDatas());

        return "covid19_korea";
    }
}
