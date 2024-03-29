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

import cz.uhk.fim.ppro.projekt.Katastr;
import cz.uhk.fim.ppro.projekt.ListVlastnictvi;
import cz.uhk.fim.ppro.projekt.Spravce;
import cz.uhk.fim.ppro.projekt.validation.ListVlastnictviValidator;

@Controller
@RequestMapping("/listyVlastnictvi/novy")
@SessionAttributes(types = ListVlastnictvi.class)
public class AddLvForm {

	private final Spravce spravce;


	@Autowired
	public AddLvForm(Spravce spravce) {
		this.spravce = spravce;
	}
	
	@ModelAttribute("katastry")
	public Collection<Katastr> populateKatastry() {
		return this.spravce.getKatastry();
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		ListVlastnictvi lv= new ListVlastnictvi();
		model.addAttribute(lv);
		return "listyVlastnictvi/form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute ListVlastnictvi lv, BindingResult result, SessionStatus status) {
		new ListVlastnictviValidator().validate(lv, result);
		if (result.hasErrors()) {
			return "listyVlastnictvi/form";
		}
		else {
			this.spravce.storeLv(lv);
			status.setComplete();
			return "redirect:/listyVlastnictvi/" + lv.getId();
		}
	}

}
