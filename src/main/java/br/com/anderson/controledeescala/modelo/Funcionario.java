package br.com.anderson.controledeescala.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String horarioPadrao;
	@Enumerated(EnumType.STRING)
	private Funcao funcao;
	
	public Funcionario(String nome, String horarioPadrao, Funcao funcao) {
		this.nome = nome;
		this.horarioPadrao = horarioPadrao;
		this.funcao = funcao;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
		

}
