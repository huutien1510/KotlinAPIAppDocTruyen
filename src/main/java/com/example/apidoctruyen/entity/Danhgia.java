package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "danhgia")
public class Danhgia {
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

    @NotNull
    @Column(name = "sosao", nullable = false)
    private Double sosao;

    @NotNull
    @Column(name = "ngaydanhgia", nullable = false)
    private LocalDate ngaydanhgia;

}