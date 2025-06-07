package pl.pjatk.RentalService.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import pl.pjatk.RentalService.model.Movie;

import java.net.ConnectException;
import java.util.function.Supplier;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return executeWithHandling(() -> restTemplate.getForObject("http://localhost:8080/cinema/movies/" + id, Movie.class));
    }

    public void returnMovie(Long id) {
        executeWithHandling(() -> restTemplate.postForEntity("http://localhost:8080/cinema/movies/isAvailable/" + id, null, Void.class));
    }

    public void rentMovie(Long id) {
        executeWithHandling(() -> restTemplate.postForEntity("http://localhost:8080/cinema/movies/isNotAvailable/" + id, null, Void.class));
    }

    public <T> T executeWithHandling(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (HttpServerErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        } catch (ResourceAccessException e) {
            if (e.getCause() instanceof ConnectException) {
                throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT);
            }
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public void executeWithHandling(Runnable runnable) {
        try {
            runnable.run();
        } catch (HttpServerErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        } catch (ResourceAccessException e) {
            if (e.getCause() instanceof ConnectException) {
                throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT);
            }
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}