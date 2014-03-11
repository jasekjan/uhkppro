package cz.uhk.fim.ppro.projekt.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import cz.uhk.fim.ppro.projekt.Klient;

/**
 * <code>Validator</code> for <code>Owner</code> forms.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
public class KlientValidator {

	public void validate(Klient klient, Errors errors) {
		if (!StringUtils.hasLength(klient.getFirstName())) {
			errors.rejectValue("firstName", "required", "required");
		}
		if (!StringUtils.hasLength(klient.getLastName())) {
			errors.rejectValue("lastName", "required", "required");
		}
		if (!StringUtils.hasLength(klient.getStreet())) {
			errors.rejectValue("street", "required", "required");
		}
		if (!StringUtils.hasLength(klient.getCity())) {
			errors.rejectValue("city", "required", "required");
		}

		String telephone = klient.getPhoneContact();
		if (!StringUtils.hasLength(telephone)) {
			errors.rejectValue("phoneContact", "required", "required");
		}
		else {
			for (int i = 0; i < telephone.length(); ++i) {
				if ((Character.isDigit(telephone.charAt(i))) == false) {
					errors.rejectValue("phoneContact", "nonNumeric", "non-numeric");
					break;
				}
			}
		}
	}

}
