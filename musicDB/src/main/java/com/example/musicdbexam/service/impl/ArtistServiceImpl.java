package com.example.musicdbexam.service.impl;

import com.example.musicdbexam.model.entity.ArtistEntity;
import com.example.musicdbexam.model.entity.enums.ArtistNameEnum;
import com.example.musicdbexam.repository.ArtistRepository;
import com.example.musicdbexam.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {
        if (artistRepository.count() == 0) {
            Arrays.stream(ArtistNameEnum.values())
                    .forEach(artistNameEnum -> {
                        ArtistEntity artistEntity = new ArtistEntity();
                        artistEntity.setName(artistNameEnum);
                        switch (artistNameEnum) {
                            case Queen -> artistEntity.setCareerInformation("Queen are a British rock band formed in London in 1970. " +
                                    "Their classic line-up was Freddie Mercury (lead vocals, piano), Brian May (guitar, vocals), Roger " +
                                    "Taylor (drums, vocals) and John Deacon (bass). Their earliest works were influenced by progressive rock, " +
                                    "hard rock and heavy metal, but the band gradually ventured into more conventional and radio-friendly works " +
                                    "by incorporating further styles, such as arena rock and pop rock.");
                            case Metallica -> artistEntity.setCareerInformation("Metallica is an American heavy metal band. The band was formed in " +
                                    "1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San " +
                                    "Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them " +
                                    "one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current " +
                                    "lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett," +
                                    " and bassist Robert Trujillo. Guitarist Dave Mustaine and bassists Ron McGovney, Cliff Burton and Jason Newsted are " +
                                    "former members of the band.");
                            case Madonna -> artistEntity.setCareerInformation("Madonna Louise Ciccone - born and raised in Michigan, Madonna moved to New " +
                                    "York City in 1978 to pursue a career in modern dance. After performing as a drummer, guitarist, and vocalist in the rock " +
                                    "bands Breakfast Club and Emmy, she rose to solo stardom with her debut studio album, Madonna (1983). She followed it with a " +
                                    "series of successful albums, including all-time bestsellers Like a Virgin (1984) and True Blue (1986) as well as Grammy Award " +
                                    "winners Ray of Light (1998) and Confessions on a Dance Floor (2005).");
                        }
                        artistRepository.save(artistEntity);
                    });
        }
    }

    @Override
    public ArtistEntity findArtistByName(ArtistNameEnum name) {
        return artistRepository.findByName(name)
                .orElse(null);
    }


}
