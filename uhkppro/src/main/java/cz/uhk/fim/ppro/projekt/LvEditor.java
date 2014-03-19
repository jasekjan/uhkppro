package cz.uhk.fim.ppro.projekt;

import java.beans.PropertyEditorSupport;

public class LvEditor extends PropertyEditorSupport {
	private final Spravce spravce;


	public LvEditor(Spravce spravce) {
		this.spravce = spravce;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		for (ListVlastnictvi lv: this.spravce.getListyVlastnictvi()) {
			if ((lv.getCislo().toString()  +'(' + lv.getKatastr().getKod().toString() + ')').equals(text)) {
				setValue(lv);
			}
		}
	}
}
