package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
    @Id
    @Column(name = "conference_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner_id;

    int conference_category;

    LocalDateTime call_start_time;

    LocalDateTime call_end_time;

    String thumbnail_url;

    String title;

    String description;

    boolean is_active;
}
