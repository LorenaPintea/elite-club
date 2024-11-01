package com.clubs.eliteclub.service;

import com.clubs.eliteclub.dto.ClubDTO;
import com.clubs.eliteclub.model.Club;
import com.clubs.eliteclub.model.SearchCriteria;
import com.clubs.eliteclub.repository.EliteClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubServiceImplementation implements EliteClubService {
    private final EliteClubRepository eliteClubRepository;

    public EliteClubServiceImplementation(EliteClubRepository eliteClubRepository) {
        this.eliteClubRepository = eliteClubRepository;
    }

    public List<ClubDTO> getAll() {
        return eliteClubRepository.findAll()
                .stream()
                .map(club -> new ClubDTO(club.getName(), club.getRating()))
                .collect(Collectors.toList());
    }

    public ClubDTO getByID(long id) {
        Club club = eliteClubRepository.findById(id).orElse(null);

        if (club != null) {
            return new ClubDTO(club.getName(), club.getRating());
        }

        return null;
    }

    private String buildSearchLikePattern(String name) {
        return (name != null ? name.toLowerCase() : "") + "%";
    }

    public List<ClubDTO> searchClub(SearchCriteria searchCriteria) {
        List<Club> clubs = eliteClubRepository.findClubs(buildSearchLikePattern(searchCriteria.getClubName()));

        if (searchCriteria.getRating() > 0 && searchCriteria.getRating() < 6) {
            // Filter with rating set
            return clubs.stream()
                    .filter(club -> club.getRating() >= searchCriteria.getRating())
                    .map(club -> new ClubDTO(club.getName(), club.getRating()))
                    .collect(Collectors.toList());
        }
        // Filter without rating set
        return clubs.stream()
                .map(club -> new ClubDTO(club.getName(), club.getRating()))
                .collect(Collectors.toList());

    }

    public void addClub(String... clubNames) {
        for (String clubName : clubNames) {
            Club eliteClub = new Club();
            eliteClub.setName(clubName);
            eliteClub.setRating((Math.random() * 5) + 1);
            eliteClubRepository.save(eliteClub);
        }
    }

    public ClubDTO updateClub(long id, ClubDTO clubDTO) {
        Club club = new Club();
        club.setId(id);
        club.setName(clubDTO.getClubName());
        club.setRating(clubDTO.getRating());

        final Club updatedClub = eliteClubRepository.save(club);
        return new ClubDTO(updatedClub.getName(), updatedClub.getRating());
    }

    public void deleteClub(long id) {
        eliteClubRepository.deleteById(id);
    }
}
