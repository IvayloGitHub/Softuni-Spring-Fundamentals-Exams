package com.example.musicdbexam.model.binding;

import com.example.musicdbexam.model.entity.enums.ArtistNameEnum;
import com.example.musicdbexam.model.entity.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistNameEnum artist;
    private GenreEnum genre;
    private String description;


    public AlbumAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Size(min = 5, message = "Image url must be more than 5 characters")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Positive(message = "Price must be positive")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Min(value = 10, message = "Copies must be more than 10")
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @NotNull
    @PastOrPresent(message = "Release date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @NotNull(message = "You must select artist")
    public ArtistNameEnum getArtist() {
        return artist;
    }

    public void setArtist(ArtistNameEnum artist) {
        this.artist = artist;
    }
    @NotNull(message = "You must select genre")
    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    @NotNull
    @Size(min = 5, message = "Description url must be more than 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
