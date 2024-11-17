package com.example.apidoctruyen.model;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuanTruyenDto {
    private String linkAnh;
    private String email;
    private String noidung;
    private LocalDate ngaydang;
    private String tenChapter;

}
