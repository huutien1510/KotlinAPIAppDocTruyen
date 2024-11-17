package com.example.apidoctruyen.model;


import com.example.apidoctruyen.entity.Truyen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDto {

    private Integer id;
    private Integer idtruyen;
    private String tenchapter;
    private LocalDate ngaydang;
    private Integer soluotxem;
    private Double danhgia;

}
