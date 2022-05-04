package br.com.anderson.controledeescala.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.controledeescala.modelo.Feriado;
import br.com.anderson.controledeescala.modelo.Mes;
import br.com.anderson.controledeescala.repository.FeriadoRepository;

@Service
public class FeriadoService {

	@Autowired
	private FeriadoRepository feriadoRepository;
	
	public List<Feriado> feriadosDoMes(Mes mes) {

		return feriadoRepository.findByMes(mes);
	}

	public Boolean consultaSeDiaEhFeriado(Mes mes, int dia) {
		
		Calendar calendar = Calendar.getInstance();
		Optional<Feriado> feriado = feriadoRepository.findByMesAndDiaAndAno(mes, dia,calendar.get(Calendar.YEAR));
		if(feriado.isPresent())
			return true;
		return false;
	}
	
}
