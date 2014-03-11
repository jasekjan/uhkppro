package cz.uhk.fim.ppro.projekt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cz.uhk.fim.ppro.projekt.Katastry;
import cz.uhk.fim.ppro.projekt.Klienti;
import cz.uhk.fim.ppro.projekt.ListyVlastnictvi;
import cz.uhk.fim.ppro.projekt.Parcely;
import cz.uhk.fim.ppro.projekt.Smlouvy;
import cz.uhk.fim.ppro.projekt.Spravce;

@Controller
public class SpravceController {
	private final Spravce spravce;
	

	@Autowired
	public SpravceController(Spravce spravce) {
		this.spravce = spravce;
	}
	
	@RequestMapping("/")
	public String welcomeHandler() {
		return "welcome";
	}
	
	@RequestMapping("/klienti")
	public ModelMap klientiHandler() {
		Klienti klienti = new Klienti();
		klienti.getKlientList().addAll(this.spravce.getKlienti());
		return new ModelMap(klienti);
	}
	
	@RequestMapping("/katastry")
	public ModelMap katastryHandler() {
		Katastry katastry = new Katastry();
		katastry.getKatastrList().addAll(this.spravce.getKatastry());
		return new ModelMap(katastry);
	}
	
	@RequestMapping("/parcely")
	public ModelMap parcelyHandler() {
		Parcely parcely= new Parcely();
		parcely.getParcelaList().addAll(this.spravce.getParcely());
		return new ModelMap(parcely);
	}

	@RequestMapping("/listyVlastnictvi")
	public ModelMap lvsHandler() {
		ListyVlastnictvi listyVlastnictvi= new ListyVlastnictvi();
		listyVlastnictvi.getListVlastnictviList().addAll(this.spravce.getListyVlastnictvi());
		return new ModelMap(listyVlastnictvi);
	}

	
	@RequestMapping("/smlouvy")
	public ModelMap smlovuyHandler() {
		Smlouvy smlouvy= new Smlouvy();
		smlouvy.getSmlouvaList().addAll(this.spravce.getSmlouvy());
		return new ModelMap(smlouvy);
	}

	/**
	 * Custom handler for displaying an owner.
	 *
	 * @param ownerId the ID of the owner to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/klienti/{klientId}")
	public ModelAndView klientHandler(@PathVariable("klientId") int klientId) {
		ModelAndView mav = new ModelAndView("klienti/show");
		mav.addObject(this.spravce.loadKlient(klientId));
		return mav;
	}
	
	@RequestMapping("/katastry/{katastrId}")
	public ModelAndView katastrHandler(@PathVariable("katastrId") int katastrId) {
		ModelAndView mav = new ModelAndView("katastry/show");
		mav.addObject(this.spravce.loadKatastr(katastrId));
		return mav;
	}

	@RequestMapping("/listyVlastnictvi/{lvId}")
	public ModelAndView listVlastnictviHandler(@PathVariable("lvId") int lvId) {
		ModelAndView mav = new ModelAndView("listyVlastnictvi/show");
		mav.addObject(this.spravce.loadLv(lvId));
		return mav;
	}
	
	@RequestMapping("/parcely/{parcelaId}")
	public ModelAndView parcelaHandler(@PathVariable("parcelaId") int parcelaId) {
		ModelAndView mav = new ModelAndView("parcely/show");
		mav.addObject(this.spravce.loadParcela(parcelaId));
		return mav;
	}
	
	@RequestMapping("/smlouvy/{smlouvaId}")
	public ModelAndView smlouvaHandler(@PathVariable("smlouvaId") int smlouvaId) {
		ModelAndView mav = new ModelAndView("smlouvy/show");
		mav.addObject(this.spravce.loadSmlouva(smlouvaId));
		return mav;
	}
	
}
