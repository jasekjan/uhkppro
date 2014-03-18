package cz.uhk.fim.ppro.projekt.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cz.uhk.fim.ppro.projekt.Klient;
import cz.uhk.fim.ppro.projekt.Smlouva;
import cz.uhk.fim.ppro.projekt.Spravce;
import cz.uhk.fim.ppro.projekt.validation.SmlouvaValidator;

/**
 * JavaBean form controller that is used to add a new <code>Owner</code> to the
 * system.
 * 
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/smlouvy/novy")
@SessionAttributes(types = Smlouva.class)
public class AddSmlouvaForm {

	private final Spravce spravce;

	@Autowired
	public AddSmlouvaForm(Spravce spravce) {
		this.spravce = spravce;
	}

	@ModelAttribute("klienti")
	public Collection<Klient> populateKlienti() {
		return this.spravce.getKlienti();
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Smlouva smlouva = new Smlouva();
		model.addAttribute(smlouva);
		return "katastry/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Smlouva smlouva,
			BindingResult result, SessionStatus status) {
		new SmlouvaValidator().validate(smlouva, result);
		if (result.hasErrors()) {
			return "smlovuy/form";
		} else {
			this.spravce.storeSmlouva(smlouva);
			status.setComplete();
			return "redirect:/smlouvy/" + smlouva.getId();
		}
	}

}
