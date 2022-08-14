package com.example.spotifyplaylist.model.binding;

import com.example.spotifyplaylist.model.entity.enums.StyleNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongAddBindingModel {

    private String performer;
    private String title;
    private LocalDate releaseDate;
    private Integer duration;
    private StyleNameEnum style;

    public SongAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Performer name length must be between 3 and 20 characters!")
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }
    @NotBlank
    @Size(min = 2, max = 20, message = "Title length must be between 2 and 20 characters!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @PastOrPresent(message = "The date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }


    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NotNull
    @Positive(message = "Duration must be positive!")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @NotNull(message = "You must select a style!")
    public StyleNameEnum getStyle() {
        return style;
    }

    public void setStyle(StyleNameEnum style) {
        this.style = style;
    }
}
