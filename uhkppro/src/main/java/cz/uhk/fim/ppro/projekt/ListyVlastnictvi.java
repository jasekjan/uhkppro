package cz.uhk.fim.ppro.projekt;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean domain object representing a list of veterinarians. Mostly
 * here to be used for the 'vets'
 * {@link org.springframework.web.servlet.view.xml.MarshallingView}.
 * 
 * @author Arjen Poutsma
 */
public class ListyVlastnictvi {

	private List<ListVlastnictvi> listyVlastnictvi;

	public List<ListVlastnictvi> getListVlastnictviList() {
		if (listyVlastnictvi == null) {
			listyVlastnictvi = new ArrayList<ListVlastnictvi>();
		}
		return listyVlastnictvi;
	}

}