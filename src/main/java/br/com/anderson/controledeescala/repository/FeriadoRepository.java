package br.com.anderson.controledeescala.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anderson.controledeescala.modelo.Feriado;
import br.com.anderson.controledeescala.modelo.Mes;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long> {

	List<Feriado> findByMes(Mes mes);

	Optional<Feriado> findByMesAndDiaAndAno(Mes mes, int dia, int ano);

}
