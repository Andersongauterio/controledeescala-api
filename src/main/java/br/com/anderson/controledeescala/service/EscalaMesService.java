package br.com.anderson.controledeescala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.controledeescala.modelo.EscalaMes;
import br.com.anderson.controledeescala.repository.EscalaMesRepository;

@Service
public class EscalaMesService {

	@Autowired
	private EscalaMesRepository escalaMesRepository;
	
	public void salvarEscalaDoMes(EscalaMes escalaDoMes) {
		escalaMesRepository.save(escalaDoMes);
	}
}
