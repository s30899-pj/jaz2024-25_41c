package pl.pjatk.PatSza2;

import org.springframework.stereotype.Component;

@Component
public class QaService implements HandlerServiceInterface {

    @Override
    public String sendMessage() {
        return "Hello from Qa";
    }

    @Override
    public String getServiceType() {
        return "qa";
    }
}
