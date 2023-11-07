package com.driver;

public class Director {
    private String name;
    private int noOfMovies;
    private double imdbRating;

    public Director(String name, int noOfMovies, double imdbRating) {
        this.name = name;
        this.noOfMovies = noOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfMovies() {
        return noOfMovies;
    }

    public void setNoOfMovies(int noOfMovies) {
        this.noOfMovies = noOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
