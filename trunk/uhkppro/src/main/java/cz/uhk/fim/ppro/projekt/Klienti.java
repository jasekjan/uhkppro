package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple JavaBean domain object representing a list of veterinarians. Mostly here to be used for the 'vets'
 * {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Arjen Poutsma
 */
public class Klienti {

	private List<Klient> klienti;

	public List<Klient> getKlientList() {
		if (klienti == null) {
			klienti = new ArrayList<Klient>();
		}
		return klienti;
	}

}