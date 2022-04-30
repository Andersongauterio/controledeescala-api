package br.com.anderson.controledeescala.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EscalaMes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private Integer ano;
	@OneToMany(mappedBy = "escalaMes")
	private List<EscalaDia> escalaPorDia = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<EscalaDia> getEscalaPorDia() {
		return escalaPorDia;
	}

	public void setEscalaPorDia(List<EscalaDia> escalaPorDia) {
		this.escalaPorDia = escalaPorDia;
	}

	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}	
	
	
	
}
