package com.example.is.controller;

import com.example.is.constants.Constants;
import com.example.is.converter.SocioConverter;
import com.example.is.entity.Socio;
import com.example.is.model.SocioModel;
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
    private int eliminado=0;
    private int sinRegistros=0;

    private static final Log LOG = LogFactory.getLog(CrudController.class);
    @Autowired
    @Qualifier("socioServiceImpl")
    private SocioService socioService;

    @Autowired
    @Qualifier("socioConverter")
    private SocioConverter socioConverter;

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/example/registrar");
    }

    @GetMapping("/registrar")
    public ModelAndView base(Model model) {
        model.addAttribute("socio", new SocioModel());
        model.addAttribute("success", registroExitoso);
        registroExitoso=0;
        return new ModelAndView(Constants.REGISTRAR_SOCIO);
    }

    @PostMapping("/socio")
    public String registrarUsuario(@ModelAttribute("socio") SocioModel socioModel) {
        Socio socio=socioConverter.modelToEntity(socioModel);
        socio = socioService.registrar(socio);
        if(socio!=null) {
            registroExitoso = 1;
        }
        return "redirect:/example/registrar";
    }

    @GetMapping("/consultar")
    public ModelAndView consultarUsuarios(Model model){
        LOG.info("Call: "+ "consultarUsuarios()");
       ModelAndView mav = new ModelAndView(Constants.CONSULTAR_SOCIO);
       model.addAttribute("socioModel",new SocioModel());
       mav.addObject("socios",socioService.consultar());
       return mav;
    }

    @GetMapping("/buscar")
    public ModelAndView consultarUsuarioNombre(@ModelAttribute("socioModel") SocioModel socioModel){
        LOG.info("Call: "+ "consultarUsuariosNombre()");
        ModelAndView mav = new ModelAndView(Constants.CONSULTAR_SOCIO);
        mav.addObject("socios",socioService.consultarByNombre(socioModel.getNombre()));
        return mav;
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminarUsuarioID(Model model){
        LOG.info("Call: "+ "eliminarUsuarioID()");
        ModelAndView mav = new ModelAndView(Constants.ELIMINAR_SOCIO);
        model.addAttribute("socioID", new SocioModel());
        model.addAttribute("eliminado", eliminado);
        model.addAttribute("sinregistros", sinRegistros);
        eliminado=0;
        sinRegistros=0;
        return mav;
    }
    @PostMapping("/eliminarUsuario")
    public ModelAndView eliminarUsuario(@ModelAttribute("socioID") SocioModel socioModel){
        LOG.info("Call: "+ "eliminarUsuario()");
        ModelAndView mav = new ModelAndView(Constants.ELIMINAR_SOCIO);
        List<Socio> socioList = socioService.consultarByNombre(socioModel.getNombre());
        mav.addObject("socios",socioList);
        if(socioList != null){
            for (Socio soc: socioList) {
                socioService.eliminar(soc.getId());
            }
            eliminado=1;
        }
        else{
            sinRegistros=1;
        }
        return mav;
    }
}
