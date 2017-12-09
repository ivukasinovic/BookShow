package bookshow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author IvanV
 */
@Controller
public class IndexController {

    @GetMapping({"/"})
    public String index() {
        return "forward:index.html";
    }
}
