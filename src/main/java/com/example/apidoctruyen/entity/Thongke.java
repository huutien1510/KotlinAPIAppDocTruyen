package com.example.apidoctruyen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "thongke")
public class Thongke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtruyen")
    private Truyen idtruyen;

    @NotNull
    @Column(name = "tongluotxem", nullable = false)
    private Integer tongluotxem;

    @NotNull
    @Column(name = "sosaotb", nullable = false)
    private Double sosaotb;




}