package cz.uhk.fim.ppro.projekt.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import cz.uhk.fim.ppro.projekt.Smlouva;

public class SmlouvaValidator {

	public void validate(Smlouva smlouva, Errors errors) {
		if (!StringUtils.hasLength(smlouva.getIdentifikator())) {
			errors.rejectValue("identifikator", "required", "required");
		}
	}

}
