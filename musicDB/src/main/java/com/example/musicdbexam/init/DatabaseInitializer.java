package com.example.musicdbexam.init;

import com.example.musicdbexam.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final ArtistService artistService;

    public DatabaseInitializer(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
            artistService.initArtists();
    }
}
