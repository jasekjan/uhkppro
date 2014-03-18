package cz.uhk.fim.ppro.projekt.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.fim.ppro.projekt.Klient;
import cz.uhk.fim.ppro.projekt.Spravce;

public class FindKlientiForm {
	private final Spravce spravce;


	@Autowired
	public FindKlientiForm(Spravce spravce) {
		this.spravce = spravce;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/klienti/search", method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("klient", new Klient());
		return "klienti/search";
	}

	@RequestMapping(value = "/klienti", method = RequestMethod.GET)
	public String processSubmit(Klient klient, BindingResult result, Model model) {

		// allow parameterless GET request for /owners to return all records
		if (klient.getLastName() == null) {
			klient.setLastName(""); // empty string signifies broadest possible search
		}

		// find owners by last name
		Collection<Klient> results = this.spravce.findKlienti(klient.getLastName());
		if (results.size() < 1) {
			// no owners found
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/search";
		}
		if (results.size() > 1) {
			// multiple owners found
			model.addAttribute("selections", results);
			return "owners/list";
		}
		else {
			// 1 owner found
			klient = results.iterator().next();
			return "redirect:/klienti/" + klient.getId();
		}
	}

}
