package com.cenfotec.atletas.controllers;



import com.cenfotec.atletas.domain.Atleta;
import com.cenfotec.atletas.domain.ImcAtleta;
import com.cenfotec.atletas.services.AtletaService;
import com.cenfotec.atletas.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class AtletasController {

    @Autowired
     AtletaService atletaService;


    @Autowired
    ImcService imcService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Atleta());
        return "insertar";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarAction(Atleta atleta, BindingResult result, Model model) {
        double imc = atleta.getPeso() / (atleta.getEstatura() * atleta.getEstatura());
        atleta.setImc(imc);
        atletaService.save(atleta);
        ImcAtleta imcDeAtleta = new ImcAtleta(String.valueOf(imc),atleta.getId(),String.valueOf(LocalDate.now()));
        imcService.save(imcDeAtleta);
        return "index";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("atletas",atletaService.getAll());
        return "listar";
    }

    @RequestMapping("/verDatos/{id}")
    public String recuperarDatosDeAtleta(Model model, @PathVariable long id){
        Optional<Atleta> atleta = atletaService.get(id);

        if (atleta.isPresent()){
            model.addAttribute("nombreCompleto", atleta.get().getNombreCompleto());
            model.addAttribute("fechaNacimiento", atleta.get().getFechaNacimiento());
            model.addAttribute("deporte", atleta.get().getDeporte());
            model.addAttribute("estatura", atleta.get().getEstatura());
            model.addAttribute("peso", atleta.get().getPeso());
            model.addAttribute("ramCompetitiva", atleta.get().getRamaCompetitiva());
            model.addAttribute("imc", atleta.get().getImc());
            model.addAttribute("pcd", atleta.get().getProvincia()+","+atleta.get().getCanton()+","+atleta.get().getDistrito());
            model.addAttribute("correo", atleta.get().getCorreo());
            model.addAttribute("telefono", atleta.get().getTelefono());
            model.addAttribute("direccion", atleta.get().getDireccion());
            return "verDatosAtleta";
        }
        return "notFound";
    }

    @RequestMapping("/updateAtleta/{id}")
    public String actualizarDatosAtleta(Model model, @PathVariable long id){
        Optional<Atleta> atleta = atletaService.get(id);

        if (atleta.isPresent()){
            model.addAttribute(atleta.get());
            return "updateAtleta";
        }
        return "notFound";
    }

    @RequestMapping("/confirmarUpdate/{id}")
    public String actualizarDatosAtletaConfirmacion(Atleta atleta, BindingResult result, Model model, @PathVariable long id){
        Optional<Atleta> originalAtleta = atletaService.get(id);
        if(originalAtleta.isPresent()){
            if(originalAtleta.get().getPeso() != atleta.getPeso()){
                double imc = atleta.getPeso() / (originalAtleta.get().getEstatura() * originalAtleta.get().getEstatura());
                ImcAtleta nuevoImc = new ImcAtleta(String.valueOf(imc),id,String.valueOf(LocalDate.now()));
                imcService.save(nuevoImc);
            }
            atletaService.update(atleta,id);
            return "index";
        }

        return "notFound";

    }

    @RequestMapping("/buscador")
    public String cargarVistaBuscador(Model model){
        model.addAttribute(new Atleta());
        return "buscador";
    }

    @RequestMapping("/resultadoBusqueda")
    public String realizarBusqueda(Atleta atleta,Model model){
        model.addAttribute("atletas",atletaService.getBusqueda(atleta.getNombreCompleto()));
        return "resultadoBusqueda";
    }

    @RequestMapping("/historialImc/{id}")
    public String verHistorialIMC(Model model, @PathVariable long id){
        List<ImcAtleta> listaImcs = imcService.getAll();
        List<ImcAtleta> listaOficial = new ArrayList<>();

        for(int i = 0;i<listaImcs.size();i++){
            if(listaImcs.get(i).getIdAtleta() == id){
                listaOficial.add(listaImcs.get(i));
            }
        }


        model.addAttribute("imcs", listaOficial);

        return "historialImc";


    }
}
