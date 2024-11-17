package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "noidungchapter")
public class Noidungchapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idchapter")
    private Chapter idchapter;


    @NotNull
    //@Lob


    @Column(name = "linkanh")

    private String linkanh;

    public Noidungchapter(Integer id, Chapter idchapter, String linkanh) {
        this.id = id;
        this.idchapter = idchapter;
        this.linkanh = linkanh;
    }

    public Noidungchapter() {

    }
}