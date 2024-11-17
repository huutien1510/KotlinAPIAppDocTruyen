package com.example.apidoctruyen.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterModel {
    private Integer id;
    private Integer idtruyen;
    private Integer soluotxem;
    private Double danhgia;
    private String tenchapter;
    private LocalDate ngaydang;

}
