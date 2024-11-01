package com.clubs.eliteclub.dto;

import java.io.Serializable;

public class ClubDTO implements Serializable {
    private final String clubName;
    private final double rating;

    public ClubDTO(String clubName, double rating) {
        this.clubName = clubName;
        this.rating = rating;
    }

    public String getClubName() {
        return clubName;
    }

    public double getRating() {
        return rating;
    }
}
