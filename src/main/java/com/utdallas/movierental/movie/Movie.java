package com.utdallas.movierental.movie;

public class Movie {

    private String title;
    private MovieType movieType;
    
    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}