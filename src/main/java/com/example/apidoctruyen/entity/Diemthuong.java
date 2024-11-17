package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "diemthuong")
public class Diemthuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtaikhoan")
    private Taikhoan idtaikhoan;

    //TODO [JPA Buddy] generate columns from DB
}