package org.cloudfoundry.samples.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ALBUM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ARTIST")
    private String artist;

    @Column(name = "RELEASEYEAR")
    private String releaseYear;

    @Column(name = "GENRE")
    private String genre;

    private Integer trackCount;

    private String albumId;

}
