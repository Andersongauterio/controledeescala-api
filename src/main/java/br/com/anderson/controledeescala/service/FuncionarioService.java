package br.com.anderson.controledeescala.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscaPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return funcionario.get();
		}
		throw new EntityNotFoundException("Funcionário não encontrato");
	}

	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
}
