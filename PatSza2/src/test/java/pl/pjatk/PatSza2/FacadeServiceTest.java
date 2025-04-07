package pl.pjatk.PatSza2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacadeServiceTest {

    private FacadeService facadeService;

    @BeforeEach
    void setUp() {
        HandlerServiceInterface devService = new DevService();
        HandlerServiceInterface qaService = new QaService();
        HandlerServiceInterface prodService = new ProdService();
        HandlerServiceInterface stageService = new StageService();

        List<HandlerServiceInterface> handlerServices = List.of(devService, qaService, prodService, stageService);
        facadeService = new FacadeService(handlerServices);
    }

    @Test
    void testExecuteDevEnvironment() {
        String result = facadeService.execute("dev");
        assertEquals("Hello from Dev", result);
    }

    @Test
    void testExecuteQaEnvironment() {
        String result = facadeService.execute("qa");
        assertEquals("Hello from Qa", result);
    }

    @Test
    void testExecuteProdEnvironment() {
        String result = facadeService.execute("prod");
        assertEquals("Hello from Prod", result);
    }

    @Test
    void testExecuteStageEnvironment() {
        String result = facadeService.execute("stage");
        assertEquals("Hello from Staging", result);
    }

    @Test
    void testExecuteDefaultEnvironment() {
        String result = facadeService.execute("unknown");
        assertEquals("Hello from Dev", result);
    }

    @Test
    void testExecuteWithNullEnvironment() {
        String result = facadeService.execute(null);
        assertEquals("Hello from Dev", result);
    }
}