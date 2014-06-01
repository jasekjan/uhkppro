package cz.uhk.fim.ppro.projekt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SMLOUVY")
public class Smlouva extends BaseEntity {

	private String identifikator;
	private Date ucinnostOd;
	private Date ucinnostDo;
	private Klient klient;
	private Integer sazbaHa;

	public String getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(String identifikator) {
		this.identifikator = identifikator;
	}
	
	public Date getUcinnostOd() {
		return ucinnostOd;
	}

	public void setUcinnostOd(Date ucinnostOd) {
		this.ucinnostOd = ucinnostOd;
	}
	
	public Date getUcinnostDo() {
		return ucinnostDo;
	}

	public void setUcinnostDo(Date ucinnostDo) {
		this.ucinnostDo = ucinnostDo;
	}

	@ManyToOne
	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Integer getSazbaHa() {
		return sazbaHa;
	}

	public void setSazbaHa(Integer sazbaHa) {
		this.sazbaHa = sazbaHa;
	}
}
