package br.com.anderson.controledeescala.service;

import java.util.ArrayList;
import java.util.List;

import br.com.anderson.controledeescala.modelo.Funcao;
import br.com.anderson.controledeescala.modelo.Funcionario;

public class FuncionariosService {

	private Funcao funcao;
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public FuncionariosService() {
		carregaFuncionarios();
	}

	private void carregaFuncionarios() {
			this.funcao = Funcao.FARMACEUTICO;
			cadastraFuncionario("Fama 1", "13:15 às 16:00 e 16:00 as 22:15");
			cadastraFuncionario("Farma 2", "07:30 às 13:15 e 14:30 às 16:40");
			
			this.funcao = Funcao.GESTOR;
			cadastraFuncionario("Gestor", "07:30 às 11:30");
			
			this.funcao = Funcao.CAIXA;
			cadastraFuncionario("Caixa 1", "07:30 às 12:15 e 13:30 às 16:15");
			cadastraFuncionario("Caixa 2", "07:30 às 13:15 e 14:30 às 16:15");
			cadastraFuncionario("Caixa 3", "08:30 às 13:15 e 14:30 às 17:15");
			cadastraFuncionario("Caixa 4", "10:30 às 13:40 e 15:00 às 19:30");
			cadastraFuncionario("Caixa 5", "07:30 às 13:15 e 14:30 às 19:00");
			cadastraFuncionario("Caixa 6", "13:15 às 14:45 e 16:00 às 22:00");
			cadastraFuncionario("Caixa 7", "13:15 às 14:45 e 16:00 às 22:00");
			cadastraFuncionario("Caixa 8", "13:15 às 14:45 e 16:00 às 22:00");
			cadastraFuncionario("Caixa 9", "13:15 às 14:45 e 16:00 às 22:00");			
			
	}

	private void cadastraFuncionario(String nomeFuncionario, String HorarioPadrao) {
		Funcionario funcionario = new Funcionario(nomeFuncionario, HorarioPadrao, this.funcao);
		this.funcionarios.add(funcionario);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public Funcionario getFuncionarioByID(Integer id) {
		return funcionarios.get(id);
	}
	
}
