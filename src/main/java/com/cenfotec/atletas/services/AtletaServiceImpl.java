package com.cenfotec.atletas.services;

import com.cenfotec.atletas.domain.Atleta;
import com.cenfotec.atletas.repo.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService {

    @Autowired
    AtletaRepository repo;

    @Override
    public void save(Atleta atleta) {
        repo.save(atleta);
    }

    @Override
    public void update(Atleta atleta,long id) {
        Atleta atletaActulizar = repo.getById(id);
        atletaActulizar.setDireccion(atleta.getDireccion());
        atletaActulizar.setProvincia(atleta.getProvincia());
        atletaActulizar.setCanton(atleta.getCanton());
        atletaActulizar.setDistrito(atleta.getDistrito());
        atletaActulizar.setTelefono(atleta.getTelefono());
        atletaActulizar.setCorreo(atleta.getCorreo());
        atletaActulizar.setPeso(atleta.getPeso());
        repo.save(atletaActulizar);
    }

    @Override
    public Optional<Atleta> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Atleta> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Atleta> getBusqueda(String text) {
        List<Atleta> listaTodos = repo.findAll();
        List<Atleta> listaOficial = new ArrayList<>();
        for(int i = 0;i < listaTodos.size();i++){
            if(listaTodos.get(i).getNombreCompleto().contains(text)){
                listaOficial.add(listaTodos.get(i));
            }
        }
        return listaOficial;
    }

    @Override
    public List<Atleta> find(String nombre) {
        return null;
    }


}
