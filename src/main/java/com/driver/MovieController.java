package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
       movieService.addMovie(movie);
       return new ResponseEntity<>("New Movie added SucessFully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director added Sucessfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director)
    {
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie director pair added sucessfully" ,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
        List<String> movies = movieService.findAllMoviesFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies()
    {
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + " removed Sucessfully ",HttpStatus.CREATED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All directors Deleted Sucessfully" , HttpStatus.CREATED);
    }

}
