package com.gromagz.education;

public class Rating {
    private float rating;

    public Rating() {
        // Default constructor required for Firebase
    }

    public Rating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
