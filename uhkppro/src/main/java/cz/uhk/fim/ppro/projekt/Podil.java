package cz.uhk.fim.ppro.projekt;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PODILY")
public class Podil extends BaseEntity{

	private Integer citatel;
	private Integer jmenovatel;
	private Klient klient;
	private ListVlastnictvi lv;
	
	public Integer getCitatel() {
		return citatel;
	}
	public void setCitatel(Integer citatel) {
		this.citatel = citatel;
	}
	public Integer getJmenovatel() {
		return jmenovatel;
	}
	public void setJmenovatel(Integer jmenovatel) {
		this.jmenovatel = jmenovatel;
	}
	
	@ManyToOne
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	
	@ManyToOne
	public ListVlastnictvi getLv() {
		return lv;
	}
	public void setLv(ListVlastnictvi lv) {
		this.lv = lv;
	}	
	
}
