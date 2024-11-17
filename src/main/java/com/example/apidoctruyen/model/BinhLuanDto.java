package com.example.apidoctruyen.model;

public class BinhLuanDto {
    private Integer id;
    private Integer idchapter;
    private Integer idtaikhoan;
    private String noidung;
    private String ngaydang;
    private Integer trangthai;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdchapter(Integer idchapter) {
        this.idchapter = idchapter;
    }

    public void setIdtaikhoan(Integer idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdchapter() {
        return idchapter;
    }

    public Integer getIdtaikhoan() {
        return idtaikhoan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public BinhLuanDto() {
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public BinhLuanDto(Integer id, Integer idchapter, Integer idtaikhoan, String noidung, String ngaydang, Integer trangthai) {
        this.id = id;
        this.idchapter = idchapter;
        this.idtaikhoan = idtaikhoan;
        this.noidung = noidung;
        this.ngaydang = ngaydang;
        this.trangthai = trangthai;
    }
}
