package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "binhluan")
public class Binhluan {
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
    @Nationalized
    @Column(name = "noidung", nullable = false)
    private String noidung;

    @NotNull
    @Column(name = "ngaydang", nullable = false)
    private LocalDate ngaydang;

    @NotNull
    @Column(name = "trangthai", nullable = false)
    private Integer trangthai;

}