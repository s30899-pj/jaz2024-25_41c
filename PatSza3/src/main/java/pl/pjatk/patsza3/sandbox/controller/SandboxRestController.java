package pl.pjatk.patsza3.sandbox.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.patsza3.car.model.Car;
import pl.pjatk.patsza3.car.service.CarService;

@RestController
@RequestMapping(value = "/homework")
public class SandboxRestController {

    private final CarService carService;

    public SandboxRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{variable}")
    public ResponseEntity<String> responseUserPV(@PathVariable("variable") String response) {
        return ResponseEntity.ok(response);
    }

    @GetMapping("/value")
    public ResponseEntity<String> responseUserRP(@RequestParam(defaultValue = "None") String response) {
        return ResponseEntity.ok(response);
    }

    //Dodatkowe
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car newCar) {
        return ResponseEntity.ok(carService.addCar(newCar));
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car carDetails, @PathVariable int id) {
        return carService.updateCar(id, carDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        if (carService.deleteCar(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        throw new RuntimeException("This is a test");
    }
}
