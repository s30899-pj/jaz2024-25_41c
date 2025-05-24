package pl.pjatk.RentalService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.model.Movie;
import pl.pjatk.RentalService.service.RentalService;

@RestController
@RequestMapping("/customer")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PostMapping("/movie/isAvailable/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/movie/isNotAvailable/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.noContent().build();
    }


}
