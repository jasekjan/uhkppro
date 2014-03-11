package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple JavaBean domain object representing a list of veterinarians. Mostly here to be used for the 'vets'
 * {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Arjen Poutsma
 */
public class Smlouvy {

	private List<Smlouva> smlouvy;

	public List<Smlouva> getSmlouvaList() {
		if (smlouvy == null) {
			smlouvy = new ArrayList<Smlouva>();
		}
		return smlouvy;
	}

}