package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.entity.Taikhoan;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuanCuaToi {
    private Integer id;
    private Integer idchapter;
    private Integer idtaikhoan;
    private String noidung;
    private LocalDate ngaydang;
    private Integer trangthai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdchapter() {
        return idchapter;
    }

    public void setIdchapter(Integer idchapter) {
        this.idchapter = idchapter;
    }

    public Integer getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(Integer idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public LocalDate getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(LocalDate ngaydang) {
        this.ngaydang = ngaydang;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }
}
