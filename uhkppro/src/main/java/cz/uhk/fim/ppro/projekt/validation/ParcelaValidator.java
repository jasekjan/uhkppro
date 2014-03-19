package cz.uhk.fim.ppro.projekt.validation;

import org.springframework.util.StringUtils;
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
	/*	if (!StringUtils.hasLength(parcela.getKmenoveCislo().toString())) {
			errors.rejectValue("kmenoveCislo", "required", "required");
		} else {
			for (int i = 0; i < parcela.getKmenoveCislo().toString().length(); ++i) {
				if ((Character.isDigit(parcela.getKmenoveCislo().toString()
						.charAt(i))) == false) {
					errors.rejectValue("kmenoveCislo", "nonNumeric",
							"non-numeric");
					break;
				}
			}
		}
		
		if (!StringUtils.hasLength(parcela.getPodlomeniCisla().toString())) {
			errors.rejectValue("podlomeniCisla", "required", "required");
		} else {
			for (int i = 0; i < parcela.getPodlomeniCisla().toString().length(); ++i) {
				if ((Character.isDigit(parcela.getPodlomeniCisla().toString()
						.charAt(i))) == false) {
					errors.rejectValue("podlomeniCisla", "nonNumeric",
							"non-numeric");
					break;
				}
			}
		}*/

	}

}
