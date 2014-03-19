package cz.uhk.fim.ppro.projekt;
import java.util.ArrayList;
import java.util.List;

public class ListyVlastnictvi {

	private List<ListVlastnictvi> listyVlastnictvi;

	public List<ListVlastnictvi> getListVlastnictviList() {
		if (listyVlastnictvi == null) {
			listyVlastnictvi = new ArrayList<ListVlastnictvi>();
		}
		return listyVlastnictvi;
	}

}