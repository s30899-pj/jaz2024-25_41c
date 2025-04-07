package pl.pjatk.patsza3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    private final List<Car> cars;

    public CarRepository() {
        this.cars = buildFakeCars();
    }

    private List<Car> buildFakeCars() {
        Car car1 = new Car(1, "BMW", "Red");
        Car car2 = new Car(2, "Audi", "Blue");
        Car car3 = new Car(3, "Mercedes-Benz", "Green");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        return cars;
    }

    public Optional<Car> findCarByID(int id) {
        return cars.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void save(Car car) {
        cars.removeIf(c -> c.getId() == car.getId());
        cars.add(car);
    }

    public void delete(Car car) {
        cars.remove(car);
    }

}
