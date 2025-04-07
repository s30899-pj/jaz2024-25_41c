package pl.pjatk.PatSza.FirstPart;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ThirdClass {

    public ThirdClass(ApplicationContext applicationContext) {
        FirstClass firstClass = applicationContext.getBean("firstClass", FirstClass.class);
        SecondClass secondClass = applicationContext.getBean("secondClass", SecondClass.class);
        firstClass.printMessage();
        secondClass.printMessage();
    }
}
