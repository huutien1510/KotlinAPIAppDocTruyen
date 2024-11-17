package com.example.apidoctruyen.model;

import com.example.apidoctruyen.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class TaiKhoanDto {
    private Integer id;
    private String email;
    private String matkhau;
    private String hoten;
    private String dienthoai;
    private Integer diemthuong;


    private Integer loaitk;


    public TaiKhoanDto(Integer id, String email, String matkhau, String hoten, String dienthoai, Integer diemthuong, Integer loaitk) {
        this.id = id;
        this.email = email;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.dienthoai = dienthoai;
        this.diemthuong = diemthuong;
        this.loaitk = loaitk;
    }

    public TaiKhoanDto(Integer id, String email, String hoten, String dienthoai, Integer diemthuong) {
        this.id = id;
        this.email = email;
        this.hoten = hoten;
        this.dienthoai = dienthoai;
        this.diemthuong = diemthuong;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public void setDiemthuong(Integer diemthuong) {
        this.diemthuong = diemthuong;
    }


    public void setLoaitk(Integer loaitk) {
        this.loaitk = loaitk;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public Integer getDiemthuong() {
        return diemthuong;
    }


    public Integer getLoaitk() {
        return loaitk;
    }
}
