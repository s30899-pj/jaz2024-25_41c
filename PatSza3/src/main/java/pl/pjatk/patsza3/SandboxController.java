package pl.pjatk.patsza3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class SandboxController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(@RequestParam Optional<String> reqParam) {
        return ResponseEntity.ok(reqParam.orElse("Hello World"));
    }

//    @GetMapping("/model")
//    public ResponseEntity<Car> getCar() {
//        Car car = new Car();
//        car.setModel("BMW");
//        car.setColor("red");
//        return ResponseEntity.ok(car);
//    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> responseUser(@PathVariable("someValue") String someValue) {
        return ResponseEntity.ok(someValue);
    }

//    @PostMapping("/model")
//    public ResponseEntity<Car> postCar(@RequestBody Car newCar) {
//        Car car = new Car();
//        car.setId(newCar.getId());
//        car.setModel(newCar.getModel());
//        car.setColor(newCar.getColor());
//        return ResponseEntity.ok(car);
//    }

}
