package cz.uhk.fim.ppro.projekt;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PAR_VE_SML")
public class ParcelaSmlouva extends BaseEntity {

	private Smlouva smlouva;
	private Parcela parcela;
	
	@ManyToOne
	public Parcela getParcela() {
		return parcela;
	}
	
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	@ManyToOne
	public Smlouva getSmlouva() {
		return smlouva;
	}

	public void setSmlouva(Smlouva smlouva) {
		this.smlouva = smlouva;
	}	
}
