package cz.uhk.fim.ppro.projekt;

import java.beans.PropertyEditorSupport;

public class KlientEditor extends PropertyEditorSupport {
	private final Spravce spravce;


	public KlientEditor(Spravce spravce) {
		this.spravce = spravce;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		for (Klient kl: this.spravce.getKlienti()) {
			if ((kl.getLastName()  +' '+kl.getFirstName()+'(' + kl.getCity() + ')').equals(text)) {
				setValue(kl);
			}
		}
	}
}
