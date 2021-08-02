package com.cenfotec.atletas.services;

import com.cenfotec.atletas.domain.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaService {

    public void save(Atleta atleta);
    public void update(Atleta atleta,long id);
    public Optional<Atleta> get(Long id);
    public List<Atleta> getAll();
    public List<Atleta> getBusqueda(String text);
    public List<Atleta> find(String nombre);

}
