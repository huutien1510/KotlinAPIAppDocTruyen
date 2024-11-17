package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lichsudoctruyen")
public class Lichsudoctruyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idchapter")
    private Chapter idchapter;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtaikhoan", nullable = false)
    private Taikhoan idtaikhoan;

    public Lichsudoctruyen(Integer id, Chapter idchapter, Taikhoan idtaikhoan) {
        this.id = id;
        this.idchapter = idchapter;
        this.idtaikhoan = idtaikhoan;
    }

    public Lichsudoctruyen() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chapter getIdchapter() {
        return idchapter;
    }

    public void setIdchapter(Chapter idchapter) {
        this.idchapter = idchapter;
    }

    public Taikhoan getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(Taikhoan idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }
}