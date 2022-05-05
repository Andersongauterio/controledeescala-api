package br.com.anderson.controledeescala.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.anderson.controledeescala.modelo.EscalaDia;
import br.com.anderson.controledeescala.modelo.EscalaFuncionarioDia;
import br.com.anderson.controledeescala.modelo.EscalaMes;
import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.modelo.Mes;
import br.com.anderson.controledeescala.service.EscalaMesService;
import br.com.anderson.controledeescala.service.FeriadoService;
import br.com.anderson.controledeescala.service.FuncionarioService;

@RestController
@RequestMapping("/escala")
public class EscalaController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EscalaMesService escalaMesService;
	
	@Autowired
	private FeriadoService feriadoService;
	
	private Calendar calendar = Calendar.getInstance();
	
	@GetMapping("/montaEscalaMes")
	public EscalaMes buscaEscala(@RequestParam String mes) {
		EscalaMes escalaDoMes = montaEscala(Mes.valueOf(mes.toUpperCase()));
		escalaMesService.salvarEscalaDoMes(escalaDoMes);
		return escalaDoMes; 
	}
	
	public EscalaMes montaEscala(Mes mes) {
		
		EscalaMes escalaDoMes = new EscalaMes();
		escalaDoMes.setAno(calendar.get(Calendar.YEAR));
		escalaDoMes.setMes(mes);
		escalaDoMes.setEscalaPorDia(criarEscalaPorDiaDoMes(mes));
		return escalaDoMes;
	}

	private List<EscalaDia> criarEscalaPorDiaDoMes(Mes mes) {
		
		List<EscalaDia> escalaPorDia = criaEscalaDosFuncionariosPorDia(mes);	
		
		return escalaPorDia;
	}

	private List<EscalaDia> criaEscalaDosFuncionariosPorDia(Mes mes) {
		
		List<EscalaDia> escalaPorDia = new ArrayList<EscalaDia>();
		
		calendar.set(Calendar.MONTH, mes.ordinal());
		
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			EscalaDia escalaDia = new EscalaDia(i, mes);
			escalaDia.setFeriado(feriadoService.consultaSeDiaEhFeriado(mes, i));
			List<EscalaFuncionarioDia> escalasDeFuncionariosDoDia = new ArrayList<>();
			int numeroDeFuncionarios = funcionarioService.getFuncionarios().size();
			for (int j = 1; j <= numeroDeFuncionarios; j++) {
				EscalaFuncionarioDia escalaDoDiaDoFuncionario = criaEscalaDoFuncionario(funcionarioService.buscaPorId((long)j), i, mes);
				escalasDeFuncionariosDoDia.add(escalaDoDiaDoFuncionario);
			} 
			escalaDia.setEscalaFuncionarioDia(escalasDeFuncionariosDoDia);
			escalaPorDia.add(escalaDia);
		}
				
		return escalaPorDia;
	}

	private EscalaFuncionarioDia criaEscalaDoFuncionario(Funcionario funcionario, int dia, Mes mes) {
		EscalaFuncionarioDia escalaDoDiaDoFuncionario = new EscalaFuncionarioDia(funcionario, dia, mes, 2022, funcionario.getFuncao(), funcionario.getHorarioPadrao(), false);
		return escalaDoDiaDoFuncionario;
	}
	
}

	