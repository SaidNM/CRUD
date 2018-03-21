package com.example.is.controller;

import com.example.is.constants.Constants;
import com.example.is.entity.Socio;
import com.example.is.service.SocioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by saidn on 20/03/2018.
 */
@Controller
@RequestMapping("/example")
public class CrudController {
    private int registroExitoso=0;

    private static final Log LOG = LogFactory.getLog(CrudController.class);
    @Autowired
    @Qualifier("socioServiceImpl")
    private SocioService socioService;

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/example/registrar");
    }

    @GetMapping("/registrar")
    public ModelAndView base(Model model) {
        model.addAttribute("socio", new Socio());
        model.addAttribute("success", registroExitoso);
        registroExitoso=0;
        return new ModelAndView(Constants.REGISTRAR_SOCIO);
    }

    @PostMapping("/socio")
    public String registrarUsuario(@ModelAttribute("socio") Socio socio) {
        socio = socioService.registrar(socio);
        if(socio!=null) {
            registroExitoso = 1;
        }
        return "redirect:/example/registrar";
    }

    @GetMapping("/consultar")
    public ModelAndView consultarUsuarios(){
        LOG.info("Call: "+ "consultarUsuarios()");
       ModelAndView mav = new ModelAndView(Constants.CONSULTAR_SOCIO);
       mav.addObject("socios",socioService.consultar());
       return mav;
    }
}
