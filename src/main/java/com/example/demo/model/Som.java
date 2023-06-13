package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.stereotype.Component;
	
//    @Component
	@Entity
	@Table(name = "tabella1")
	public
	
	class Som {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(name = "codice_Comune")
	  private String codistat_comune_dom;
	  
	  @Column(name = "comune")
	  private String comune_dom;
	  
	  @Column(name = "provincia")
	  private String provincia_dom;
	  
	  @Column(name = "prima_dose")
	  private int tot_solo_dose_1;
	  
	  @Column(name = "seconda_dose")
	  private int tot_dose_2_unica;
	  
	  @Column(name = "terza_dose")
	  private int tot_dose_addizionale_booster;
	  
	  @Column(name = "richiamo")
	  private int tot_dose_richimm_rich2_;
	  
	  public void setData(Long id, String c_com, String comun, String province, int primaDose, int secondaDose, int terzaDose, int richiamo) {
		    this.id = id;
		    this.codistat_comune_dom = c_com;
		    this.comune_dom = comun;
		    this.provincia_dom = province;
		    this.tot_solo_dose_1 = primaDose;
		    this.tot_dose_2_unica = secondaDose;
		    this.tot_dose_addizionale_booster = terzaDose;
		    this.tot_dose_richimm_rich2_ = richiamo;
		}

	public String getCodistat_comune_dom() {
		return codistat_comune_dom;
	}

	public String getComune_dom() {
		return comune_dom;
	}

	public String getProvincia_dom() {
		return provincia_dom;
	}

	public int getTot_solo_dose_1() {
		return tot_solo_dose_1;
	}

	public int getTot_dose_2_unica() {
		return tot_dose_2_unica;
	}

	public int getTot_dose_addizionale_booster() {
		return tot_dose_addizionale_booster;
	}

	public int getTot_dose_richimm_rich2_() {
		return tot_dose_richimm_rich2_;
	}
}

