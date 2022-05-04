package br.com.anderson.controledeescala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.controledeescala.modelo.EscalaFuncionarioDia;
import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.modelo.Mes;

public interface EscalaFuncionarioDiaRepository extends JpaRepository<EscalaFuncionarioDia, Long> {
	
	EscalaFuncionarioDia findByFuncionarioAndDiaAndMesAndAno(Funcionario funcionario, Integer dia, Mes mes, Integer ano);

}
