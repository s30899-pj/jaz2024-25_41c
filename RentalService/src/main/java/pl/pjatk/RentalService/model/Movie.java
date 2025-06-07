package pl.pjatk.RentalService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Schema(description = "Movie ID", example = "1")
    private Integer id;
    @Schema(description = "Movie title", example = "Scream")
    private String title;
    @Schema(description = "Movie category", example = "horror")
    private String category;
    @Schema(description = "Movie release date", example = "1996-12-18")
    private LocalDate releaseDate;
    @Schema(description = "Movie duration in minutes", example = "111")
    private Integer duration;
    @Schema(description = "Movie availability", example = "true", defaultValue = "false")
    private boolean available = false;

}