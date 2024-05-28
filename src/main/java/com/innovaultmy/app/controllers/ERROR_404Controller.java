package com.innovaultmy.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paginas")
public class ERROR_404Controller {
    @GetMapping("/ERROR_404")
    public ModelAndView VerAdminObjetos()
    {
        return new ModelAndView("paginas/ERROR_404");
    }

}