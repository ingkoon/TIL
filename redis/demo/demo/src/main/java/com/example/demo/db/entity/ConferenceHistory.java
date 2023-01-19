package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conferenceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    private short action;

    private LocalDateTime insertedTime;
}
