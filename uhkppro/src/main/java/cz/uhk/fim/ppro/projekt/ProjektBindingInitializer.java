package cz.uhk.fim.ppro.projekt;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;


/**
 * Shared WebBindingInitializer for PetClinic's custom editors.
 *
 * <p>Alternatively, such init-binder code may be put into
 * {@link org.springframework.web.bind.annotation.InitBinder}
 * annotated methods on the controller classes themselves.
 *
 * @author Juergen Hoeller
 */
@Controller
public class ProjektBindingInitializer implements WebBindingInitializer {
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		//binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}
