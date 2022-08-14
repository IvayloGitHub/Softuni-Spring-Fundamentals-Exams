package com.example.spotifyplaylist.init;

import com.example.spotifyplaylist.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final StyleService styleService;

    public DatabaseInitializer(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {
            styleService.initStyles();
    }
}
