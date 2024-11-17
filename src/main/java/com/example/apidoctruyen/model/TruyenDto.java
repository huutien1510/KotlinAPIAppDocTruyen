package com.example.apidoctruyen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruyenDto {
    private Integer id;
    private String tentruyen;
    private String tacgia;
    private String mota;
    private String theloai;
    private String linkanh;
    private Integer trangthai;
    private String key_search;
}
