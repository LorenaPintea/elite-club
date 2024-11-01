package com.clubs.eliteclub;

import com.clubs.eliteclub.service.EliteClubServiceImplementation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.clubs.eliteclub.model")
public class EliteClubApplication implements ApplicationRunner {

    private final EliteClubServiceImplementation eliteClubService;

    public EliteClubApplication(EliteClubServiceImplementation eliteClubService) {
        this.eliteClubService = eliteClubService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EliteClubApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        eliteClubService.addClub("Billionaire", "Environmentalist", "Poker");
    }

}
