package br.com.anderson.controledeescala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.controledeescala.modelo.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
