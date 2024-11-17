package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Taikhoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LichsudoctruyenModel {
    private Integer id;
    private Integer idchapter;
    private Integer idtaikhoan;
}
