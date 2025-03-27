package pl.pjatk.PatSza2;

public class RequestExecutor {

    public RequestExecutor(FacadeService facadeService) {
        System.out.println(facadeService.execute());
    }
}
