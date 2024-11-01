package com.clubs.eliteclub.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class SearchCriteria {
    @Pattern(regexp = "\\w+", message = "Club name must be alphanumeric")
    private String clubName;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must not exceed 5")
    private double rating;

    public @Pattern(regexp = "(\\w+)") String getClubName() {
        return clubName;
    }

    public void setClubName(@Pattern(regexp = "(\\w+)") String clubName) {
        this.clubName = clubName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
