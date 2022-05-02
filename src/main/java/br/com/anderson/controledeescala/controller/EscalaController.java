package br.com.anderson.controledeescala.controller;

import java.util.ArrayList;
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
import br.com.anderson.controledeescala.service.FuncionariosService;

@RestController
@RequestMapping("/escala")
public class EscalaController {
	
	@Autowired
	private FuncionariosService funcionarioService;
	
	@Autowired
	private EscalaMesService escalaMesService;
	
	@GetMapping("/buscaEscalaMes")
	public EscalaMes buscaEscala(@RequestParam String mes, @RequestParam Integer ano) {
		Mes m = Mes.valueOf(mes);
		EscalaMes escalaDoMes = montaEscala(m, ano);
		escalaMesService.salvarEscalaDoMes(escalaDoMes);
		return escalaDoMes; 
	}
	
	public EscalaMes montaEscala(Mes mes, Integer ano) {
		
		EscalaMes escalaDoMes = new EscalaMes();
		escalaDoMes.setAno(ano);
		escalaDoMes.setMes(mes);
		escalaDoMes.setEscalaPorDia(criarEscalaPorDiaDoMes(mes));
		return escalaDoMes;
	}

	private List<EscalaDia> criarEscalaPorDiaDoMes(Mes mes) {
		
		List<EscalaDia> escalaPorDia = criaEscalaDosFuncionariosPorDia(mes);	
		
		return escalaPorDia;
	}

	private List<EscalaDia> criaEscalaDosFuncionariosPorDia(Mes mes) {
		List<EscalaFuncionarioDia> escalasDeFuncionariosDoDia = new ArrayList<>();
		List<EscalaDia> escalaPorDia = new ArrayList<EscalaDia>();
		for (int i = 1; i < 31; i++) {
			EscalaDia escalaDia = new EscalaDia(i, mes);
			for (int j = 1; j <= funcionarioService.getFuncionarios().size(); j++) {
				EscalaFuncionarioDia escalaDoDiaDoFuncionario = carregaEscalaDoFuncionario(funcionarioService.findById((long)j), i, mes);
				escalasDeFuncionariosDoDia.add(escalaDoDiaDoFuncionario);
			} 
			escalaDia.setEscalaFuncionarioDia(escalasDeFuncionariosDoDia);
			escalaPorDia.add(escalaDia);
		}
		
		
		return escalaPorDia;
	}

	private EscalaFuncionarioDia carregaEscalaDoFuncionario(Funcionario funcionario, int dia, Mes mes) {
		EscalaFuncionarioDia escalaDoDiaDoFuncionario = new EscalaFuncionarioDia(funcionario, dia, mes, 2022, funcionario.getFuncao(), funcionario.getHorarioPadrao(), false);
		System.out.println(funcionario.getNome() + " Dia " + dia + " Mes " + mes.toString() + " Hora padrão: " + funcionario.getHorarioPadrao().toString());
		return escalaDoDiaDoFuncionario;
	}
	
}

	