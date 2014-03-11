package cz.uhk.fim.ppro.projekt.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import cz.uhk.fim.ppro.projekt.Katastr;

/**
 * <code>Validator</code> for <code>Owner</code> forms.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
public class KatastrValidator {

	public void validate(Katastr katastr, Errors errors) {
		/*if (!NumberUtils.hasLength(katastr.getKod())) {
			errors.rejectValue("kod", "required", "required");
		}*/
		if (!StringUtils.hasLength(katastr.getNazev())) {
			errors.rejectValue("nazev", "required", "required");
		}
	}

}
