package pl.pjatk.PatSza;

import org.springframework.stereotype.Component;

@Component
public class SecondClass {

    public SecondClass(FirstClass firstClass) {
        System.out.println("SecondClass");
    }

    public void printMessage() {
        System.out.println("SecondClass call from print method");
    }

}
