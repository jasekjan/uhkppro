package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple JavaBean domain object representing a list of veterinarians. Mostly here to be used for the 'vets'
 * {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Arjen Poutsma
 */
public class Parcely {

	private List<Parcela> parcely;

	public List<Parcela> getParcelaList() {
		if (parcely == null) {
			parcely = new ArrayList<Parcela>();
		}
		return parcely;
	}

}