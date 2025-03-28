package pl.pjatk.PatSza2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RequestExecutor {

    private final FacadeService facadeService;

    public RequestExecutor(FacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @PostConstruct
    public void executeAfterStartup() {
        System.out.println(facadeService.execute());
    }
}