package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtruyen")
    private Truyen idtruyen;

    //@Size(max = 20)
    @NotNull
    @Column(name = "tenchapter", nullable = false, length = 20)
    private String tenchapter;

    @NotNull
    @Column(name = "ngaydang", nullable = false)
    private LocalDate ngaydang;

    @NotNull
    @Column(name = "soluotxem", nullable = false)
    private Integer soluotxem;

    @NotNull
    @Column(name = "danhgia", nullable = false)
    private Double danhgia;

    @OneToMany(mappedBy = "idchapter")
    private Set<Binhluan> binhluans = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idchapter")
    private Set<Danhgia> danhgias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idchapter")
    private Set<Lichsudoctruyen> lichsudoctruyens = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idchapter")
    private Set<Noidungchapter> noidungchapters = new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name = "truyen_id")
    private Truyen truyen;

}

