
package cz.uhk.fim.ppro.projekt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cz.uhk.fim.ppro.projekt.Klient;
import cz.uhk.fim.ppro.projekt.Spravce;
import cz.uhk.fim.ppro.projekt.validation.KlientValidator;

/**
 * JavaBean Form controller that is used to edit an existing <code>Owner</code>.
 * 
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/klienti/{klientId}/edit")
@SessionAttributes(types = Klient.class)
public class EditKlientForm {

	private final Spravce spravce;


	@Autowired
	public EditKlientForm(Spravce spravce) {
		this.spravce = spravce;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@PathVariable("klientId") int klientId, Model model) {
		Klient klient = this.spravce.loadKlient(klientId);
		model.addAttribute(klient);
		return "klienti/form";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String processSubmit(@ModelAttribute Klient klient, BindingResult result, SessionStatus status) {
		new KlientValidator().validate(klient, result);
		if (result.hasErrors()) {
			return "klienti/form";
		}
		else {
			this.spravce.storeKlient(klient);
			status.setComplete();
			return "redirect:/klienti/" + klient.getId();
		}
	}

}
