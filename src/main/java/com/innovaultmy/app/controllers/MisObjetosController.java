package com.innovaultmy.app.controllers;


import com.innovaultmy.app.models.FilamentoModel;
import com.innovaultmy.app.models.UsuarioModel;
import com.innovaultmy.app.models.VariosModel;
import com.innovaultmy.app.repositories.registros.FilamentoRepository;
import com.innovaultmy.app.repositories.registros.VariosRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Usuario")
public class MisObjetosController {
    private final VariosRepository variosRepository;
    private final FilamentoRepository filamentoRepository;
    public MisObjetosController(VariosRepository variosRepository, FilamentoRepository filamentoRepository){
        this.variosRepository = variosRepository;
        this.filamentoRepository = filamentoRepository;
    }

    @GetMapping("/MisObjetos")
    public ModelAndView mostrarMisObjetos(HttpSession session, @PageableDefault(size = 20) Pageable pageable) {

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuario");
        Page<VariosModel> varios = variosRepository.findByMisobjetosV(usuario.getId(),pageable);
        Page<FilamentoModel> filamentos = filamentoRepository.findByMisobjetosF(usuario.getId(),pageable);

        return new ModelAndView("paginas/MisObjetos")
                .addObject("varios", varios)
                .addObject("filamentos", filamentos);
    }

}