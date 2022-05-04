package br.com.anderson.controledeescala.dto;

import br.com.anderson.controledeescala.modelo.Feriado;

public class FeriadoDto {
	
	private Integer dia;
	private String mes;
	private Integer ano;
	private String descricao;
	
	public FeriadoDto(Feriado feriado) {
		this.dia = feriado.getDia();
		this.mes = feriado.getMes().toString();
		this.ano = feriado.getAno();
		this.descricao = feriado.getDescricao();
	}
	
	public Integer getDia() {
		return dia;
	}
	public String getMes() {
		return mes;
	}
	public Integer getAno() {
		return ano;
	}
	public String getDescricao() {
		return descricao;
	}
}
