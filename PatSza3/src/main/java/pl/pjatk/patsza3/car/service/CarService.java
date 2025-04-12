package pl.pjatk.patsza3.car.service;

import org.springframework.stereotype.Service;
import pl.pjatk.patsza3.car.repository.CarRepository;
import pl.pjatk.patsza3.car.model.Car;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findCarByID(id);
    }

    public Car addCar(Car newCar) {
        carRepository.save(newCar);
        return newCar;
    }

    public Optional<Car> updateCar(int id, Car carDetails) {
        Optional<Car> existingCar = getCarById(id);
        if (existingCar.isPresent()) {
            Car updatedCar = existingCar.get();
            updatedCar.setModel(carDetails.getModel());
            updatedCar.setColor(carDetails.getColor());
            addCar(updatedCar);
            return Optional.of(updatedCar);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteCar(int id) {
        Optional<Car> carToDelete = getCarById(id);
        carToDelete.ifPresent(carRepository::delete);
        return carToDelete.isPresent();
    }

}
