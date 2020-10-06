package com.example.springwebapp.bootstrap;

import com.example.springwebapp.domain.ArtWork;
import com.example.springwebapp.domain.Artist;
import com.example.springwebapp.domain.Exhibition;
import com.example.springwebapp.repositories.ArtWorkRepository;
import com.example.springwebapp.repositories.ArtistRepository;
import com.example.springwebapp.repositories.ExhibitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ArtistRepository artistRepository;
    private final ArtWorkRepository artWorkRepository;
    private final ExhibitionRepository exhibitionRepository;

    public BootstrapData(ArtistRepository artistRepository, ArtWorkRepository artWorkRepository, ExhibitionRepository exhibitionRepository) {
        this.artistRepository = artistRepository;
        this.artWorkRepository = artWorkRepository;
        this.exhibitionRepository = exhibitionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Exhibition meeting = new Exhibition();
        meeting.setTitle("Meeting");

        exhibitionRepository.save(meeting);

        Artist inita = new Artist("Inita", "Emane");
        ArtWork paralels = new ArtWork("Paralels", "Private Collection");

        inita.getArtWorks().add(paralels);
        paralels.getArtist().add(inita);

        inita.setExhibition(meeting);
        meeting.getArtists().add(inita);

        artistRepository.save(inita);
        artWorkRepository.save(paralels);
        exhibitionRepository.save(meeting);

        Artist ernest = new Artist("Ernests", "Vitins");
        ArtWork dveseles = new ArtWork("Dveseles", "Private Collection");

        ernest.getArtWorks().add(dveseles);
        dveseles.getArtist().add(ernest);

        ernest.setExhibition(meeting);
        meeting.getArtists().add(ernest);

        artistRepository.save(ernest);
        artWorkRepository.save(dveseles);
        exhibitionRepository.save(meeting);

        System.out.println(artistRepository.count());
        System.out.println(artWorkRepository.count());
        System.out.println(meeting.getArtists().size());
        System.out.println(meeting.getArtWorks().size());


    }
}
