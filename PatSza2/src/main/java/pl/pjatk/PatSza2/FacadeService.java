package pl.pjatk.PatSza2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacadeService {
//    HandlerServiceInterface handlerService;
    private final Map<String, HandlerServiceInterface> serviceMap;

    public FacadeService(List<HandlerServiceInterface> handlerServiceInterfaces) {
        serviceMap = new HashMap<>();
        for (HandlerServiceInterface handler : handlerServiceInterfaces) {
            serviceMap.put(handler.getServiceType(), handler);
        }
    }

//    public FacadeService(List<HandlerServiceInterface> handlerServiceInterfaces, @Value("${app.environment:dev}") String appEnvironment) {
//        switch (appEnvironment) {
//            case "dev":
//                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("dev")).findFirst().orElse(null);
//                break;
//            case "qa":
//                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("qa")).findFirst().orElse(null);
//                break;
//            case "prod":
//                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("prod")).findFirst().orElse(null);
//                break;
//            case "stage":
//                handlerService = handlerServiceInterfaces.stream().filter(services -> services.getServiceType().equals("stage")).findFirst().orElse(null);
//                break;
//            default:
//                break;
//        }
//    }

    public String execute(String environment) {
        HandlerServiceInterface handlerService = serviceMap.getOrDefault(environment, serviceMap.get("dev"));
        return handlerService != null ? handlerService.sendMessage() : "No service found";
    }
}
