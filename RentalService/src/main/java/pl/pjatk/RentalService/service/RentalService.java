package pl.pjatk.RentalService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        try {
            return restTemplate.getForObject("http://localhost:8080/cinema/movies/" + id, Movie.class);
        } catch (RestClientException e) {
            System.out.println("Error fetching movie from API: " + e.getMessage());
            return null;
        }
    }

    public void returnMovie(Long id) {
        try {
            restTemplate.postForEntity("http://localhost:8080/cinema/movies/isAvailable/" + id, null, Void.class);
        } catch (RestClientException e) {
            System.out.println("Error fetching movie from API: " + e.getMessage());
        }
    }

    public void rentMovie(Long id) {
        try {
            restTemplate.postForEntity("http://localhost:8080/cinema/movies/isNotAvailable/" + id, null, Void.class);
        } catch (RestClientException e) {
            System.out.println("Error fetching movie from API: " + e.getMessage());
        }
    }
}