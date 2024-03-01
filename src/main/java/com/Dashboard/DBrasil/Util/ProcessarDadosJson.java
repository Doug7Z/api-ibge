package com.Dashboard.DBrasil.Util;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProcessarDadosJson {
	
	private final ObjectMapper objectMapper;
	
	
	
	public ProcessarDadosJson(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	
	public <T> void jsonProcessoComDatas (String json, List<T> dadosLista, Class<T> classeDTO) {		
		try {
			JsonNode leituraJson = objectMapper.readTree(json);
			JsonNode serieNode = leituraJson.get(1).get("resultados").get(0).get("series").get(0).get("serie");
			Iterator<Map.Entry<String, JsonNode>> camposIterador = serieNode.fields();
			while (camposIterador.hasNext()) {
	            Map.Entry<String, JsonNode> campos = camposIterador.next();
	            String ano = campos.getKey();
	            String valor = campos.getValue().asText();
	            T dtoInstance = classeDTO.getDeclaredConstructor(String.class, String.class)
                        .newInstance(ano, valor);
	            dadosLista.add(dtoInstance);
			}     
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
	}

	
	public <T> void jsonProcesso(String json, List<T> dadosLista, Class<T> classeDTO) {
	    try {
	        JsonNode leituraJson = objectMapper.readTree(json);
	        JsonNode campoSeries = leituraJson.get(0).get("series");
	        JsonNode subSerie = campoSeries.get(0).get("serie");
	        
	        for (JsonNode jsonNode : subSerie) {
	            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
	            
	            while (fields.hasNext()) {
	                Map.Entry<String, JsonNode> entry = fields.next();
	                String key = entry.getKey();
	                String valor = entry.getValue().asText();
	                if (!("-".equals(key)) && !"null".equals(valor)) {	                    
	                    T dtoInstance = classeDTO.getDeclaredConstructor(String.class, String.class)
	                                            .newInstance(key, valor);
	                    dadosLista.add(dtoInstance);
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
