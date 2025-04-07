package pl.pjatk.PatSza2;

import org.springframework.stereotype.Component;

@Component
public class ProdService implements HandlerServiceInterface {

    @Override
    public String sendMessage() {
        return "Hello from Prod";
    }

    @Override
    public String getServiceType() {
        return "prod";
    }
}
