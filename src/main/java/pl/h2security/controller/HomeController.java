package pl.h2security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String home(Model model) {
        return "Coś tam coś tam";
    }


    @RequestMapping("/dupa")
    @ResponseBody
    public String dupa(Model model){
        return "dupaaaa";
    }
}
