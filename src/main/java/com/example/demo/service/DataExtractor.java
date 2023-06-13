package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


import com.example.demo.ProvinceData;
import com.example.demo.model.OutputData;
import com.example.demo.model.Som;
import com.example.demo.repository.OutputDataRepository;
import com.example.demo.repository.SomRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Service
public class DataExtractor extends TimerTask{

private final String JSON_URL = "https://hub.dati.lombardia.it/resource/vtzi-zmp8.json";
List<OutputData> outputDataList;
	
//@Autowired
//private static final Logger l = LogManager.getLogger(DataExtractor.class);

  public String getJsonUrl() {
	return JSON_URL;
}
  
  public List<OutputData> getOutputDataList() {
		return outputDataList;
	}

@Autowired
//  @Bean
  public RestClient restClient;
//  getRestClient() 
//  {
//      return new RestClient();
//  }
	
@Transactional
    public void run() {
        String json = restClient.getData(getJsonUrl());
        Gson gson = new GsonBuilder().create();
        Som[] somArray = gson.fromJson(json, Som[].class);
        List<Som> somList = new ArrayList<>(Arrays.asList(somArray));
        outputDataList = new ArrayList<>();
        
        // Ciclo di manipolazione dei dati
        for (Som som : somArray) {
          OutputData outputData = new OutputData();
          outputData.setData(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
          outputData.setCodice(som.getCodistat_comune_dom());
          outputData.setComune(som.getComune_dom());
          outputData.setProvincia(som.getProvincia_dom());

          String provinceJson = restClient.getData("https://comuni-ita.herokuapp.com/api/province");
          ProvinceData[] provinceDataList = gson.fromJson(provinceJson, ProvinceData[].class);
          for (ProvinceData provinceData : provinceDataList) {
            if (provinceData.getNome().equalsIgnoreCase(outputData.getProvincia())) {
              outputData.setSigla(provinceData.getSigla().toUpperCase());
              break;
            }
          }

          outputData.setDose1(som.getTot_solo_dose_1());
          outputData.setDose2(som.getTot_dose_2_unica());
          outputData.setBooster(som.getTot_dose_addizionale_booster());
          outputData.setRichiamo(som.getTot_dose_richimm_rich2_());
          outputDataList.add(outputData);
      }  
        OutputDataRepository odr = new OutputDataRepository();
        odr.saveAll(outputDataList);
        
        
        SomRepository sr = new SomRepository();
        sr.saveAll(somList);
    }

   }
