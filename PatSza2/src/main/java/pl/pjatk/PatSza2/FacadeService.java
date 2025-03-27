package pl.pjatk.PatSza2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeService {

    HandlerServiceInterface handlerService;

    public FacadeService(List<HandlerServiceInterface> handlerServiceInterfaces, @Value("${app.environment}") String chooseProperties) {
        switch (chooseProperties) {
            case "dev":
                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("dev")).findFirst().orElse(null);
                break;
            case "qa":
                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("qa")).findFirst().orElse(null);
                break;
            case "prod":
                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("prod")).findFirst().orElse(null);
                break;
            default:
                break;
        }
    }

    public void execute(RequestExecutor executor) {
        if (handlerService != null) {
            handlerService.SendMessage();
        }
    }
}
