package com.Dashboard.DBrasil.DTO;

public class DadoIpca {
	
	 private String ano;
	 private String valor;

	 public DadoIpca(String chave, String valor) {
	   this.ano = chave;
	   this.valor = valor;
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
