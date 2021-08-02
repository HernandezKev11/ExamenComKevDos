package com.cenfotec.atletas.services;

import com.cenfotec.atletas.domain.Atleta;
import com.cenfotec.atletas.domain.ImcAtleta;
import com.cenfotec.atletas.repo.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public interface ImcService {



    public void save(ImcAtleta imcDeAtleta);

    public Optional<ImcAtleta> get(Long id);

    public List<ImcAtleta> getAll();

    public List<ImcAtleta> find(String nombre);
}
