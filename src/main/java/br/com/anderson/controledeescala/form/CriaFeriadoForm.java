package br.com.anderson.controledeescala.form;

import com.sun.istack.NotNull;

import br.com.anderson.controledeescala.modelo.Feriado;
import br.com.anderson.controledeescala.modelo.Mes;

public class CriaFeriadoForm {
	@NotNull 
	private String dia;
	@NotNull
	private String mes;
	@NotNull
	private String ano;
	private String descricao;
	
	public void setDia(String dia) {
		this.dia = dia;
	}
		
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
		
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Feriado converter() {
		return new Feriado(Integer.parseInt(this.dia), Mes.valueOf(this.mes.toUpperCase()), Integer.parseInt(this.ano), this.descricao);
	}
	
}
