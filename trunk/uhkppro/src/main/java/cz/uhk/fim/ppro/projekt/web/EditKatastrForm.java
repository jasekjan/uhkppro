
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

import cz.uhk.fim.ppro.projekt.Katastr;
import cz.uhk.fim.ppro.projekt.Spravce;
import cz.uhk.fim.ppro.projekt.validation.KatastrValidator;

/**
 * JavaBean Form controller that is used to edit an existing <code>Owner</code>.
 * 
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/katastry/{katastrId}/edit")
@SessionAttributes(types = Katastr.class)
public class EditKatastrForm {

	private final Spravce spravce;


	@Autowired
	public EditKatastrForm(Spravce spravce) {
		this.spravce = spravce;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@PathVariable("katastrId") int katastrId, Model model) {
		Katastr katastr = this.spravce.loadKatastr(katastrId);
		model.addAttribute(katastr);
		return "katastry/form";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String processSubmit(@ModelAttribute Katastr katastr, BindingResult result, SessionStatus status) {
		new KatastrValidator().validate(katastr, result);
		if (result.hasErrors()) {
			return "katastry/form";
		}
		else {
			this.spravce.storeKatastr(katastr);
			status.setComplete();
			return "redirect:/katastry/" + katastr.getId();
		}
	}

}
