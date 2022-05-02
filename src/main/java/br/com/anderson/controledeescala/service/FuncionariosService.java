package br.com.anderson.controledeescala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.repository.FuncionarioRepository;

@Service
public class FuncionariosService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return funcionario.get();
		}
		return null;
	}
	
}
