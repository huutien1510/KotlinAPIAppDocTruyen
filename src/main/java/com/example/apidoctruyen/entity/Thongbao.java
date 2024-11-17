package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thongbao")
public class Thongbao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 250)
    @NotNull
    @Nationalized
    @Column(name = "tieude", nullable = false, length = 250)
    private String tieude;

    @NotNull
    @Lob
    @Column(name = "noidung", nullable = false)
    private String noidung;

    @NotNull
    @Column(name = "ngaydang", nullable = false)
    private LocalDate ngaydang;

}