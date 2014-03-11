package cz.uhk.fim.ppro.projekt.validation;

import org.springframework.validation.Errors;

import cz.uhk.fim.ppro.projekt.Parcela;

/**
 * <code>Validator</code> for <code>Owner</code> forms.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
public class ParcelaValidator {

	public void validate(Parcela parcela, Errors errors) {
		/*if (!NumberUtils.hasLength(katastr.getKod())) {
			errors.rejectValue("kod", "required", "required");
		}*/
		
	}

}
