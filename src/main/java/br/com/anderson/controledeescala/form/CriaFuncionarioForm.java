package br.com.anderson.controledeescala.form;

import javax.validation.constraints.NotNull;

import br.com.anderson.controledeescala.modelo.Funcao;
import br.com.anderson.controledeescala.modelo.Funcionario;

public class CriaFuncionarioForm {

	@NotNull
	private String nome;
	@NotNull
	private String horarioPadrao;
	@NotNull
	private String funcao;
		
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setHorarioPadrao(String horarioPadrao) {
		this.horarioPadrao = horarioPadrao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Funcionario converter() {
		return new Funcionario(this.nome, this.horarioPadrao, Funcao.valueOf(funcao.toUpperCase()));
	}

}
