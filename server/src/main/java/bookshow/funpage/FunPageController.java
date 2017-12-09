package bookshow.funpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunPageController {

    private final FunPageService funPageService;

    @Autowired
    public FunPageController(FunPageService funPageService) {
        this.funPageService = funPageService;
    }

    @RequestMapping("/funpage")

    public String hello() {
        return funPageService.hello();
    }

}
