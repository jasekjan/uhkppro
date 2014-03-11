package cz.uhk.fim.ppro.projekt;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PARCELY")
public class Parcela extends BaseEntity{
	private Integer kmenoveCislo;
	private Integer podlomeniCisla;
	private float vymera;
	private ListVlastnictvi lv;
	private Set<ParcelaSmlouva> parSml;
	
	public Integer getKmenoveCislo() {
		return kmenoveCislo;
	}
	public void setKmenoveCislo(Integer kmenoveCislo) {
		this.kmenoveCislo = kmenoveCislo;
	}
	public Integer getPodlomeniCisla() {
		return podlomeniCisla;
	}
	public void setPodlomeniCisla(Integer podlomeniCisla) {
		this.podlomeniCisla = podlomeniCisla;
	}
	public float getVymera() {
		return vymera;
	}
	public void setVymera(float vymera) {
		this.vymera = vymera;
	}
	
	@ManyToOne
	public ListVlastnictvi getLv() {
		return lv;
	}
	public void setLv(ListVlastnictvi lv) {
		this.lv = lv;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="parcela")
	public Set<ParcelaSmlouva> getParSml() {
		return parSml;
	}
	
	public void setParSml(Set<ParcelaSmlouva> parSml){
		this.parSml = parSml;
	}
}
