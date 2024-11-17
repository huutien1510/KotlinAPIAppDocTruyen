package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Taikhoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhGiaCuaToiDto {
    private Integer id;

    private Integer idchapter;

    private Integer idtaikhoan;

    private Double sosao;
    private LocalDate ngaydanhgia;

}
