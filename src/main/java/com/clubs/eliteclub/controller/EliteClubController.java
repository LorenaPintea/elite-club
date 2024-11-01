package com.clubs.eliteclub.controller;

import com.clubs.eliteclub.service.EliteClubService;
import com.clubs.eliteclub.dto.ClubDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EliteClubController {
    private final EliteClubService eliteClubService;

    public EliteClubController(EliteClubService eliteClubService) {
        this.eliteClubService = eliteClubService;
    }

    @GetMapping(path="/club", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> getAllClubs() {
        return eliteClubService.getAll();
    }

    @GetMapping(path="/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClubDTO getClub(@PathVariable long id) {
        return eliteClubService.getByID(id);
    }

    @PostMapping(path="/club", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewClub(@RequestBody ClubDTO clubDTO) {
        eliteClubService.addClub(clubDTO.getClubName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/club/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDTO> searchClub(@RequestParam String name) {
        return eliteClubService.searchClub(name);
    }

    @DeleteMapping(path = "/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteClub(@PathVariable long id) {
        eliteClubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/club/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClubDTO updateClub(@PathVariable long id, @RequestBody ClubDTO clubDTO) {
        return eliteClubService.updateClub(id, clubDTO);
    }
}
