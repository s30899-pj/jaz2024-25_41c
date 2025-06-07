package pl.pjatk.RentalService.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.model.Movie;
import pl.pjatk.RentalService.service.RentalService;


@RestController
@RequestMapping("/customer")
@OpenAPIDefinition(info = @Info(
        title = "Rental Service API Documentation",
        description = "This is the documentation for the sample Rental service project with REST API"))
@Tag(name = "Rental Controller", description = "Basic endpoints for customer")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Operation(summary = "Get a movie by id", description = "Returns a movie as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found - The movie was not found", content = @Content)
    })
    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") @Parameter(name = "id", description = "Movie id", example = "1") Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @Operation(summary = "Change availability of movie on true", description = "Returns none, but changing variable in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully change availability on false"),
            @ApiResponse(responseCode = "404", description = "Not found - The movie was not found")
    })
    @PostMapping("/movie/isAvailable/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable("id") @Parameter(name = "id", description = "Movie id", example = "1") Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Change availability of movie on false", description = "Returns none, but changing variable in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully change availability on false"),
            @ApiResponse(responseCode = "404", description = "Not found - The movie was not found")
    })
    @PostMapping("/movie/isNotAvailable/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable("id") @Parameter(name = "id", description = "Movie id", example = "1") Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.noContent().build();
    }


}
