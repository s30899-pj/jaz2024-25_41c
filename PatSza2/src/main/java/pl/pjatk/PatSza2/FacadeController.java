package pl.pjatk.PatSza2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sandbox")
public class FacadeController {

    private final FacadeService facadeService;

    public FacadeController(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @GetMapping("/message")
    public String getMessage(@RequestParam(value = "environment", defaultValue = "dev") String environment) {
        return facadeService.execute(environment);
    }
}
