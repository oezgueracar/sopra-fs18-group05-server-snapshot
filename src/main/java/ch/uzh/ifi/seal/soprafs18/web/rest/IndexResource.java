package ch.uzh.ifi.seal.soprafs18.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexResource {

	@RequestMapping(value="/")
	@ResponseBody
	public ModelAndView index() {
		return new ModelAndView("redirect:https://sopra18group05.firebaseapp.com/");
	}
}
