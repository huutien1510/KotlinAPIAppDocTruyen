package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doithuong")
public class Doithuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtaikhoan")
    private Taikhoan idtaikhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idvatpham")
    private Vatpham idvatpham;

    //TODO [JPA Buddy] generate columns from DB
}