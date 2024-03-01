package com.Dashboard.DBrasil.Requester;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IBGERequester {
	
	private final RestTemplate restTemplate;
	
	public IBGERequester(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
		
	//************************* Implementado *********************************************//
	public String fazerRequisicaoIPCA(String periodoInicial , String periodoFinal) {
		String url = "https://servicodados.ibge.gov.br/api/v3/agregados/1737/periodos/"+ periodoInicial + "-" + periodoFinal + "/variaveis?localidades=BR";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
	
	public String fazerRequisicaoIPCA15 (String periodoInicial , String periodoFinal){
		String url = "https://servicodados.ibge.gov.br/api/v3/agregados/3065/periodos/"+ periodoInicial + "-" + periodoFinal + "/variaveis?localidades=BR";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}

	public String totalPib() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77827";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
	

	public String gastoEducacaoPib() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77819";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
		

	public String PIBperCapita() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77823";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}

	public String gastoSaudePib() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77820";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
	
	
	public String totalExport() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77825";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
	
	public String totalImport() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77826";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}
	
	public String IdhBrasil() {
		String url = "https://servicodados.ibge.gov.br/api/v1/paises/BR/indicadores/77831";
		ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
		return resposta.getBody();
	}

	
}
