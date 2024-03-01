package com.Dashboard.DBrasil.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Dashboard.DBrasil.DTO.CapitaPibDTO;
import com.Dashboard.DBrasil.DTO.DadoIPCA15;
import com.Dashboard.DBrasil.DTO.DadoIpca;
import com.Dashboard.DBrasil.DTO.EducDTO;
import com.Dashboard.DBrasil.DTO.ExportDTO;
import com.Dashboard.DBrasil.DTO.IdhDTO;
import com.Dashboard.DBrasil.DTO.ImportDTO;
import com.Dashboard.DBrasil.DTO.PibDTO;
import com.Dashboard.DBrasil.DTO.SaudeDTO;
import com.Dashboard.DBrasil.Requester.IBGERequester;
import com.Dashboard.DBrasil.Util.ProcessarDadosJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IBGEService {

	private final IBGERequester ibgeRequester;
	private final ProcessarDadosJson processarDadosJson;
	
	public IBGEService (IBGERequester ibgeRequester,ProcessarDadosJson processarDadosJson ) {
		this.ibgeRequester = ibgeRequester;
		this.processarDadosJson = processarDadosJson;
	}
	
	//********************************************************************//	
	
	public List<DadoIpca> obterChavesEValoresIPCA() {
		LocalDate ano = LocalDate.now();
	    int anoAtual =  ano.getYear();
	    int anoAtras = anoAtual -1;
	    String anoAtualString = String.format("%d%02d", anoAtual, 12);
	    String anoAtrasString = String.format("%d%02d", anoAtras, 1);;
		
	    List<DadoIpca> dados = new ArrayList<>();
	    String json = ibgeRequester.fazerRequisicaoIPCA(anoAtrasString, anoAtualString);
	    processarDadosJson.jsonProcessoComDatas(json, dados, DadoIpca.class);
	    return dados;
	}
		
	public List<DadoIPCA15> valoresIPCA15(){
		LocalDate ano = LocalDate.now();
	    int anoAtual =  ano.getYear();
	    int anoAtras = anoAtual -1;
	    String anoAtualString = String.format("%d%02d", anoAtual, 12);
	    String anoAtrasString = String.format("%d%02d", anoAtras, 1);;
		
	    List<DadoIPCA15> dados = new ArrayList<>();
	    String json = ibgeRequester.fazerRequisicaoIPCA15(anoAtrasString, anoAtualString);
	    processarDadosJson.jsonProcessoComDatas(json, dados, DadoIPCA15.class);
		return dados;
	}
	

	
	public List<PibDTO> respostaPIB() {
       List<PibDTO> dados = new ArrayList<>();
       String json = ibgeRequester.totalPib();       
       processarDadosJson.jsonProcesso(json, dados, PibDTO.class);
        
       return dados;
    }
	
	
	public List<EducDTO> respostaEducPib(){
		List<EducDTO> dados = new ArrayList<>();
		String json = ibgeRequester.gastoEducacaoPib();
		processarDadosJson.jsonProcesso(json, dados, EducDTO.class);
		return dados;
	}
	
	
	public List<SaudeDTO> respostaSaudePib(){
		List<SaudeDTO> dados = new ArrayList<>();
		String json = ibgeRequester.gastoSaudePib();
		processarDadosJson.jsonProcesso(json, dados, SaudeDTO.class);
		return dados;
	}
	
	
	public List<CapitaPibDTO> respostaCapitaPib(){
		List<CapitaPibDTO> dados = new ArrayList<>();
		String json = ibgeRequester.PIBperCapita();
		processarDadosJson.jsonProcesso(json, dados, CapitaPibDTO.class);
		return dados;
	}
	
	public List<ExportDTO> respostaExport(){
		List<ExportDTO> dados = new ArrayList<>();
		String json = ibgeRequester.totalExport();
		processarDadosJson.jsonProcesso(json, dados, ExportDTO.class);
		return dados;
	}
	
	public List<ImportDTO> respostaImport(){
		List<ImportDTO> dados = new ArrayList<>();
		String json = ibgeRequester.totalImport();
		processarDadosJson.jsonProcesso(json, dados, ImportDTO.class);
		return dados;
	}
	
	public List<IdhDTO> respostaIDH(){
		List<IdhDTO> dados = new ArrayList<>();
		String json = ibgeRequester.IdhBrasil();
		processarDadosJson.jsonProcesso(json, dados, IdhDTO.class);
		return dados;
	}
	
	

	
}
