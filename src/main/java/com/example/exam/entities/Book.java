package com.example.exam.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @CreationTimestamp
    @Column(name = "published_at", updatable = false, nullable = false)
    private String publishedAt;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "country_origin", nullable = false)
    private String countryOrigin;

    @Column(name = "isbn", nullable = false)
    private String isbn;

}