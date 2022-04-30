package br.com.anderson.controledeescala.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EscalaDia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer dia;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private Boolean feriado;
	@OneToMany(mappedBy = "escalaDia")
	private List<EscalaFuncionarioDia> escalaFuncionarioDia = new ArrayList<>();
	@ManyToOne
	private EscalaMes escalaMes;
		
	public EscalaDia(Integer dia, Mes mes, List<EscalaFuncionarioDia> escalaFuncionariosDia) {
		this.dia = dia;
		this.mes = mes;
		this.escalaFuncionarioDia = escalaFuncionariosDia;
	}
	
	public Boolean getFeriado() {
		return feriado;
	}

	public void setFeriado(Boolean feriado) {
		this.feriado = feriado;
	}

	public void setEscalaFuncionarioDia(List<EscalaFuncionarioDia> escalaFuncionarioDia) {
		this.escalaFuncionarioDia = escalaFuncionarioDia;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<EscalaFuncionarioDia> getEscalaFuncionarioDia() {
		return escalaFuncionarioDia;
	}
	
	public void setEscalaFuncionarioDia(ArrayList<EscalaFuncionarioDia> escalaFuncionarioDia) {
		this.escalaFuncionarioDia = escalaFuncionarioDia;
	}
	
	public Integer getDia() {
		return dia;
	}
	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	} 
}
