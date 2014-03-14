package cz.uhk.fim.ppro.projekt;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Set<Parcela> parcely;

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

	@ManyToMany
	@JoinTable(name="par_ve_sml", joinColumns={@JoinColumn(name="smlouva_id")}, inverseJoinColumns={@JoinColumn(name="parcela_id")})
	public Set<Parcela> getParcely() {
		return parcely;
	}

	public void setParcely(Set<Parcela> parcely) {
		this.parcely = parcely;
	}

}
