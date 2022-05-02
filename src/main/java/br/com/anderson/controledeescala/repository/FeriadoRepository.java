package br.com.anderson.controledeescala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.controledeescala.modelo.Feriado;

public interface FeriadoRepository extends JpaRepository<Feriado, Long> {

}
