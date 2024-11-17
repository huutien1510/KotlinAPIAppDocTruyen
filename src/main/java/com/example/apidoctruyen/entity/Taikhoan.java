package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "taikhoan")
public class Taikhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 250)
    @NotNull
    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Size(max = 250)
    @NotNull
    @Column(name = "matkhau", nullable = false, length = 250)
    private String matkhau;

    @Size(max = 250)
    @Nationalized
    @Column(name = "hoten", length = 250)
    private String hoten;

    @Size(max = 11)
    @Column(name = "dienthoai", length = 11)
    private String dienthoai;

    @NotNull
    @Column(name = "diemthuong", nullable = false)
    private Integer diemthuong;

    @NotNull
    @Column(name = "loaitk", nullable = false)
    private Integer loaitk;

    @Column(name = "linkanh")
    private String linkanh;

    @OneToMany(mappedBy = "idtaikhoan")
    private Set<Binhluan> binhluans = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtaikhoan")
    private Set<Danhgia> danhgias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtaikhoan")
    private Set<Diemthuong> diemthuongs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtaikhoan")
    private Set<Doithuong> doithuongs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idtaikhoan")
    private Set<Lichsudoctruyen> lichsudoctruyens = new LinkedHashSet<>();

}