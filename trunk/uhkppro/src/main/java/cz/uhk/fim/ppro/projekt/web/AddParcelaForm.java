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

import cz.uhk.fim.ppro.projekt.ListVlastnictvi;
import cz.uhk.fim.ppro.projekt.Parcela;
import cz.uhk.fim.ppro.projekt.Spravce;
import cz.uhk.fim.ppro.projekt.validation.ParcelaValidator;

@Controller
@RequestMapping("/parcely/novy")
@SessionAttributes(types = Parcela.class)
public class AddParcelaForm {

	private final Spravce spravce;


	@Autowired
	public AddParcelaForm(Spravce spravce) {
		this.spravce = spravce;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("listyVlastnictvi")
	public Collection<ListVlastnictvi> populateListyVlastnictvi() {
		return this.spravce.getListyVlastnictvi();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Parcela parcela= new Parcela();
		model.addAttribute(parcela);
		return "parcely/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Parcela parcela, BindingResult result, SessionStatus status) {
		new ParcelaValidator().validate(parcela, result);
		if (result.hasErrors()) {
			return "parcely/form";
		}
		else {
			this.spravce.storeParcela(parcela);
			status.setComplete();
			return "redirect:/parcely/" + parcela.getId();
		}
	}

}
