package com.example.spotifyplaylist.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
public class SongEntity extends BaseEntity {

    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private StyleEntity style;

    public SongEntity() {
    }

    @Column(nullable = false)
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Column
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToOne
    public StyleEntity getStyle() {
        return style;
    }

    public void setStyle(StyleEntity style) {
        this.style = style;
    }
}
