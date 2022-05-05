package br.com.anderson.controledeescala.form;

import br.com.anderson.controledeescala.modelo.Funcao;
import br.com.anderson.controledeescala.modelo.Funcionario;
import br.com.anderson.controledeescala.service.FuncionarioService;

public class AtualizaFuncionarioForm {
	
	private String nome;
	private String horarioPadrao;
	private String funcao;
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorarioPadrao() {
		return horarioPadrao;
	}

	public void setHorarioPadrao(String horarioPadrao) {
		this.horarioPadrao = horarioPadrao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Funcionario atualizar(Long id, FuncionarioService funcionarioService) {
		Funcionario funcionario = funcionarioService.buscaPorId(id);
		funcionario.setNome(this.nome);
		funcionario.setHorarioPadrao(this.horarioPadrao);
		funcionario.setFuncao(Funcao.valueOf(this.funcao.toUpperCase()));
		return funcionario;
	}
}
