package cz.uhk.fim.ppro.projekt;

import java.beans.PropertyEditorSupport;

/**
 * @author Mark Fisher
 * @author Juergen Hoeller
 */
public class KatastrEditor extends PropertyEditorSupport {

	private final Spravce spravce;


	public KatastrEditor(Spravce spravce) {
		this.spravce = spravce;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		for (Katastr ku: this.spravce.getKatastry()) {
			if ((ku.getNazev()  + '(' + ku.getKod().toString() + ')').equals(text)) {
				setValue(ku);
			}
		}
	}

}