package br.com.anderson.controledeescala.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.anderson.controledeescala.modelo.EscalaDia;
import br.com.anderson.controledeescala.modelo.EscalaFuncionarioDia;
import br.com.anderson.controledeescala.modelo.EscalaMes;
import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.modelo.Mes;
import br.com.anderson.controledeescala.service.FuncionariosService;

public class EscalaController {

	private FuncionariosService funcionarioService = new FuncionariosService();
	
	public EscalaMes montaEscala(Mes mes, Integer ano) {
		
		EscalaMes escalaDoMes = new EscalaMes();
		escalaDoMes.setAno(ano);
		escalaDoMes.setMes(mes);
		List<EscalaDia> listaEscalaDiaria = criarEscalaPorDiaDoMes(mes);
		escalaDoMes.setEscalaPorDia(listaEscalaDiaria);
		return escalaDoMes;
	}

	private List<EscalaDia> criarEscalaPorDiaDoMes(Mes mes) {
		
		List<EscalaDia> escalaPorDia = new ArrayList<>();
		
		for (int i = 1; i < 32; i++) {
			criaEscalaDosFuncionariosPorDia(i, mes);	
			System.out.println("-----------------------------------");
		}
			
		return escalaPorDia;
	}

	private List<EscalaFuncionarioDia> criaEscalaDosFuncionariosPorDia(int dia, Mes mes) {
		List<EscalaFuncionarioDia> escalasDeFuncionariosDoDia = new ArrayList<>();
		for (int i = 0; i < funcionarioService.getFuncionarios().size(); i++) {
			EscalaFuncionarioDia escalaDoDiaDoFuncionario = carregaEscalaDoFuncionario(funcionarioService.getFuncionarioByID(i), dia, mes);
			escalasDeFuncionariosDoDia.add(escalaDoDiaDoFuncionario);
		} 
		
		return escalasDeFuncionariosDoDia;
	}

	private EscalaFuncionarioDia carregaEscalaDoFuncionario(Funcionario funcionario, int dia, Mes mes) {
		EscalaFuncionarioDia escalaDoDiaDoFuncionario = new EscalaFuncionarioDia(funcionario, dia, mes, 2022, funcionario.getFuncao(), funcionario.getHorarioPadrao(), false);
		System.out.println(funcionario.getNome() + " Dia " + dia + " Mes " + mes.toString() + " Hora padrão: " + funcionario.getHorarioPadrao().toString());
		return escalaDoDiaDoFuncionario;
	}
	
}

	