package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "truyen")
@Data

@AllArgsConstructor

@NoArgsConstructor
public class Truyen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tentruyen")
    private String tentruyen;

    @Column(name = "tacgia")
    private String tacgia;

    @Column(name = "mota")
    private String mota;

    @Column(name = "theloai")
    private String theloai;

    @Column(name = "linkanh")
    private String linkanh;

    @Column(name = "trangthai")
    private Integer trangthai;

    @Column(name = "key_search")
    private String key_search;
    @OneToMany(mappedBy = "idtruyen")
    private Set<Chapter> chapters ;

    @OneToMany(mappedBy = "idtruyen")
    private Set<Thongke> thongkes ;



}
