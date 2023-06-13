package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.stereotype.Component;

//@Component
@Entity
@Table(name = "tabella2")
public class OutputData {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	  @Column(name = "data")
    private String data;
	  
	  @Column(name = "codice_comune")
	private String codice;
	  
	  @Column(name = "comune")
	private String comune;
	  
	  @Column(name = "provincia")
	private String provincia;
	 
	  @Column(name = "sigla_provincia")
	private String sigla;
	  
	  @Column(name = "una_dose")
	private int dose1;
	  
	  @Column(name = "due_dosi")
	private int dose2;
	  
	  @Column(name = "booster")
	private int booster;
	  
	  @Column(name = "richiamo")
	private int richiamo;
	  
	  public void setData(Long id, String data, String cod, String com, String prov, String sigle, int doseUno, int doseDue, int booster, int richiamo) {
		  this.id = id;
		  this.data = data;
		  this.codice = cod;
		  this.comune = com;
		  this.provincia = prov;
		  this.sigla = sigle;
		  this.dose1 = doseUno;
		  this.dose2 = doseDue;
		  this.booster = booster;
		  this.richiamo = richiamo;
	  }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getDose1() {
		return dose1;
	}

	public void setDose1(int dose1) {
		this.dose1 = dose1;
	}

	public int getDose2() {
		return dose2;
	}

	public void setDose2(int dose2) {
		this.dose2 = dose2;
	}

	public int getBooster() {
		return booster;
	}

	public void setBooster(int booster) {
		this.booster = booster;
	}

	public int getRichiamo() {
		return richiamo;
	}

	public void setRichiamo(int richiamo) {
		this.richiamo = richiamo;
	}
  }
