package com.Dashboard.DBrasil.DTO;

public class ImportDTO {
	
	public String ano;
	
	public String valor;
	
	public ImportDTO(String ano,String valor) {
		this.ano= ano;
		this.valor= valor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
	
}
