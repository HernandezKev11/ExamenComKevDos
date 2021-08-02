package com.cenfotec.atletas.services;

import com.cenfotec.atletas.domain.Atleta;
import com.cenfotec.atletas.domain.ImcAtleta;
import com.cenfotec.atletas.repo.AtletaRepository;
import com.cenfotec.atletas.repo.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImcServiceImpl implements ImcService{

    @Autowired
    ImcRepository repo;


    @Override
    public void save(ImcAtleta imcDeAtleta) {
        repo.save(imcDeAtleta);
    }

    @Override
    public Optional<ImcAtleta> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ImcAtleta> getAll() {
        return repo.findAll();
    }

    @Override
    public List<ImcAtleta> find(String nombre) {
        return null;
    }
}
