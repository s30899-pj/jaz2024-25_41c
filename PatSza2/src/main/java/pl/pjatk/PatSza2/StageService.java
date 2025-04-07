package pl.pjatk.PatSza2;

import org.springframework.stereotype.Component;

@Component
public class StageService implements HandlerServiceInterface {

    @Override
    public String sendMessage() {
        return "Hello from Staging";
    }

    @Override
    public String getServiceType() {
        return "stage";
    }
}
