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
@Table(name = "vatpham")
public class Vatpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 250)
    @NotNull
    @Nationalized
    @Column(name = "tenvatpham", nullable = false, length = 250)
    private String tenvatpham;

    @NotNull
    @Column(name = "diem", nullable = false)
    private Integer diem;

    @NotNull
    @Lob
    @Column(name = "linkanh", nullable = false)
    private String linkanh;

    @OneToMany(mappedBy = "idvatpham")
    private Set<Doithuong> doithuongs = new LinkedHashSet<>();

}