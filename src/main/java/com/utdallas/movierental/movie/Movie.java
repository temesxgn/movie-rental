package com.utdallas.movierental.movie;

import com.utdallas.movierental.rental.Rental;
import javafx.beans.InvalidationListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Movie {

    private String title;
    private MovieType movieType;
    private PropertyChangeSupport support;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
        support = new PropertyChangeSupport(this);
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
        support.firePropertyChange("movieType", this.movieType, movieType);
        this.movieType = movieType;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}