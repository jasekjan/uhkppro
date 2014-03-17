package cz.uhk.fim.ppro.projekt;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LVS")
public class ListVlastnictvi extends BaseEntity {
	private Integer cislo;
	private Katastr katastr;	
	private Set<Parcela> parcely;
	private Set<Podil> podily;

	@ManyToOne(fetch=FetchType.EAGER)
	public Katastr getKatastr() {
		return katastr;
	}
	public void setKatastr(Katastr katastr) {
		this.katastr = katastr;
	}
	public Integer getCislo() {
		return cislo;
	}
	public void setCislo(Integer cislo) {
		this.cislo = cislo;
	}	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="lv")
	public Set<Parcela> getParcely() {
		return parcely;
	}
	public void setParcely(Set<Parcela> parcely) {
		this.parcely = parcely;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="lv")
	public Set<Podil> getPodily() {
		return podily;
	}
	
	public void setPodily(Set<Podil> podily) {
		this.podily = podily;
	}
}
