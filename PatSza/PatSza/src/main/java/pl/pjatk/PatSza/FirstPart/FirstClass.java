package pl.pjatk.PatSza.FirstPart;

import org.springframework.stereotype.Component;

@Component
public class FirstClass {

    public FirstClass() {
        System.out.println("FirstClass");
    }

    public void printMessage() {
        System.out.println("FirstClass call from print method");
    }
}
