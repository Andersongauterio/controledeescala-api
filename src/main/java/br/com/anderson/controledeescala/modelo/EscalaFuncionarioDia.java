package br.com.anderson.controledeescala.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EscalaFuncionarioDia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Funcionario funcionario;
	private Integer dia;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private Integer ano;
	@Enumerated(EnumType.STRING)
	private Funcao funcao;
	private String horario;
	private Boolean folga;
	@ManyToOne
	private EscalaDia escalaDia;
	
	public EscalaFuncionarioDia(Funcionario funcionario, Integer dia, Mes mes, Integer ano, Funcao funcao, String horario, Boolean folga) {
		this.funcionario = funcionario;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.funcao = funcao;
		this.horario = horario;
		this.folga = folga;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public Boolean getFolga() {
		return folga;
	}
	
	public void setFolga(Boolean folga) {
		this.folga = folga;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
		

}
