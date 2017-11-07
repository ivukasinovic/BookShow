package bookshow.funpage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunPageController {

	@RequestMapping("/funpage")
	public String hello() {
		return "Welcome to fun page";
	}

}
