package br.com.anderson.controledeescala.dto;

import br.com.anderson.controledeescala.modelo.Funcionario;

public class FuncionarioDto {

	private String nome;
	private String horarioPadrao;
	private String funcao;
	
	public FuncionarioDto(Funcionario funcionario) {
		this.nome = funcionario.getNome();
		this.horarioPadrao = funcionario.getHorarioPadrao();
		this.funcao = funcionario.getFuncao().toString();
	}

	public String getNome() {
		return nome;
	}

	public String getHorarioPadrao() {
		return horarioPadrao;
	}

	public String getFuncao() {
		return funcao;
	}
	
}
