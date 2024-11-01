package com.clubs.eliteclub.service;

import com.clubs.eliteclub.dto.ClubDTO;
import com.clubs.eliteclub.model.SearchCriteria;

import java.util.List;

public interface EliteClubService {

    List<ClubDTO> getAll();

    List<ClubDTO> searchClub(SearchCriteria searchCriteria);

    void addClub(String... clubNames);

    ClubDTO getByID(long id);

    void deleteClub(long id);

    ClubDTO updateClub(long id, ClubDTO updatedClub);
}
