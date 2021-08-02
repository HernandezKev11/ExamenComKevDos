package com.cenfotec.atletas.repo;

import com.cenfotec.atletas.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
}
