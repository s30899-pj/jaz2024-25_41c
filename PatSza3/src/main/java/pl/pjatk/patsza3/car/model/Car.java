package pl.pjatk.patsza3.car.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Car {
    private int id;
    private String model;
    private String color;

}