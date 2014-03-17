package cz.uhk.fim.ppro.projekt;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KATASTRY")
public class Katastr extends BaseEntity {

	private Integer kod;
	private String nazev;
	private Set<ListVlastnictvi> lvs;

	public Integer getKod() {
		return kod;
	}

	public void setKod(Integer kod) {
		this.kod = kod;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "katastr")
	public Set<ListVlastnictvi> getLvs() {
		return lvs;
	}

	public void setLvs(Set<ListVlastnictvi> lvs) {
		this.lvs = lvs;
	}

	@Override
	public String toString() {
		return nazev + '(' + kod.toString() + ')';
	}

}
