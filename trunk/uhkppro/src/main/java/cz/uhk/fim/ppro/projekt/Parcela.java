package cz.uhk.fim.ppro.projekt;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PARCELY")
public class Parcela extends BaseEntity{
	private Integer kmenoveCislo;
	private Integer podlomeniCisla;
	private float vymera;
	private ListVlastnictvi lv;
	private Set<Smlouva> smlouvy;
	
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
	
	@ManyToMany
	@JoinTable(name="par_ve_sml", joinColumns={@JoinColumn(name="parcela_id")}, inverseJoinColumns={@JoinColumn(name="smlouva_id")})
	public Set<Smlouva> getSmlouvy() {
		return smlouvy;
	}
	
	public void setSmlouvy(Set<Smlouva> smlouvy){
		this.smlouvy = smlouvy;
	}
}
