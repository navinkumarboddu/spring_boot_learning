package com.pluralsight.conferencedemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;

    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    private byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    List<Session> sessions;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Speaker() {
    }

    public byte[] getSpeakerPhoto() {
        return speaker_photo;
    }

    public void setSpeakerPhoto(byte[] speakerPhoto) {
        this.speaker_photo = speakerPhoto;
    }
}
