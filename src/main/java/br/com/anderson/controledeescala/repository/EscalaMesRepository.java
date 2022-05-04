package br.com.anderson.controledeescala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anderson.controledeescala.modelo.EscalaMes;

@Repository
public interface EscalaMesRepository extends JpaRepository<EscalaMes, Long> {

}
