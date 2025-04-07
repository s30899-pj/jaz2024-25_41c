package pl.pjatk.PatSza2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestExecutor {
    private final FacadeService facadeService;
    private final String appEnvironment;

    public RequestExecutor(FacadeService facadeService, @Value("${app.environment:dev}") String appEnvironment) {
        this.facadeService = facadeService;
        this.appEnvironment = appEnvironment;
    }

    @PostConstruct
    public void executeAfterStartup() {
        System.out.println(facadeService.execute(appEnvironment));
    }
}