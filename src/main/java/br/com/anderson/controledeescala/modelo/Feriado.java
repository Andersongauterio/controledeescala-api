package br.com.anderson.controledeescala.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feriado {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer dia;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private Integer ano;
	private String descricao;
	
	public Feriado() {
	}
	
	public Feriado(Integer dia, Mes mes, Integer ano, String descricao) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getDia() {
		return dia;
	}
	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getDescricao() {
		return descricao;
	}
		
	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
