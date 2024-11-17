package com.example.apidoctruyen.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruyenInfo {
    private Integer id;
    private Integer tongluotxem;
    private Double sosaotb;
    private String tentruyen;
    private LocalDate ngaydang;
    private String theloai;
    private String linkanh;

}
