package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;

public class Klienti {

	private List<Klient> klienti;

	public List<Klient> getKlientList() {
		if (klienti == null) {
			klienti = new ArrayList<Klient>();
		}
		return klienti;
	}

}