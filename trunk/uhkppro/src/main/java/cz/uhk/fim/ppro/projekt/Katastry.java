package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple JavaBean domain object representing a list of veterinarians. Mostly here to be used for the 'vets'
 * {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Arjen Poutsma
 */
public class Katastry {

	private List<Katastr> katastry;

	public List<Katastr> getKatastrList() {
		if (katastry == null) {
			katastry = new ArrayList<Katastr>();
		}
		return katastry;
	}

}