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
    private Integer id;          // ID của đánh giá
    private String tenTruyen;    // Tên truyện
    private String tenChapter;   // Tên chương
    private Double sosao;        // Số sao đánh giá
    private LocalDate ngaydanhgia; // Ngày đánh giá
    private String linkAnh;      // Link ảnh của truyện
    private Integer idtaikhoan;  // ID tài khoản của người đánh giá
}


