package com.Dashboard.DBrasil.Controller;


import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Dashboard.DBrasil.DTO.CapitaPibDTO;
import com.Dashboard.DBrasil.DTO.DadoIPCA15;
import com.Dashboard.DBrasil.DTO.DadoIpca;
import com.Dashboard.DBrasil.DTO.EducDTO;
import com.Dashboard.DBrasil.DTO.ExportDTO;
import com.Dashboard.DBrasil.DTO.IdhDTO;
import com.Dashboard.DBrasil.DTO.ImportDTO;
import com.Dashboard.DBrasil.DTO.PibDTO;
import com.Dashboard.DBrasil.DTO.SaudeDTO;
import com.Dashboard.DBrasil.Service.IBGEService;

@Controller
@RequestMapping("/api/ibge")
public class IBGEController {

	private final IBGEService ibgeService;
	
	
	public IBGEController(IBGEService ibgeService) {
		this.ibgeService = ibgeService;
		
	}

	 @GetMapping("/resultadoBrasil")
	    public ModelAndView obterChavesEValoresIPCA(String periodoInicial, String periodoFinal) {
		 ModelAndView modelAndView = new ModelAndView("resultadoIBGE");
		    List<DadoIpca> dadosIPCA = ibgeService.obterChavesEValoresIPCA();
	        List<DadoIPCA15> dadosIpca15 = ibgeService.valoresIPCA15(); 
	        List<PibDTO> dadospib = ibgeService.respostaPIB();
	        List<EducDTO> educPib = ibgeService.respostaEducPib();
	        List<SaudeDTO> saudePib = ibgeService.respostaSaudePib();
	        List<CapitaPibDTO> PibPerCapita = ibgeService.respostaCapitaPib();
	        List<ExportDTO> totalExport = ibgeService.respostaExport();
	        List<ImportDTO> totalImport = ibgeService.respostaImport();
	        List<IdhDTO> idhBrasil = ibgeService.respostaIDH();
	       
	        
	        
	        modelAndView.addObject("dadosIPCA", dadosIPCA);
	        modelAndView.addObject("dadosIpca15", dadosIpca15);
	        modelAndView.addObject("dadospib", dadospib);
	        modelAndView.addObject("educPib", educPib);
	        modelAndView.addObject("saudePib", saudePib);
	        modelAndView.addObject("PibPerCapita", PibPerCapita);
	        modelAndView.addObject("totalExport", totalExport);
	        modelAndView.addObject("totalImport", totalImport);
	        modelAndView.addObject("idhBrasil", idhBrasil);

	    
	        return modelAndView;
	    }
	
 

}
