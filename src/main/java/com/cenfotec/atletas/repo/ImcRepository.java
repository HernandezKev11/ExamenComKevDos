package com.cenfotec.atletas.repo;

import com.cenfotec.atletas.domain.Atleta;
import com.cenfotec.atletas.domain.ImcAtleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImcRepository extends JpaRepository<ImcAtleta, Long> {
}
