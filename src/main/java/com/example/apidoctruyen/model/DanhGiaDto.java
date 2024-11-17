package com.example.apidoctruyen.model;

public class DanhGiaDto {
    private Integer id;
    private Integer idchapter;
    private Integer idtaikhoan;
    private Double sosao;
    private String ngaydanhgia;

    public DanhGiaDto(Integer id, Integer idchapter, Integer idtaikhoan, Double sosao, String ngaydanhgia) {
        this.id = id;
        this.idchapter = idchapter;
        this.idtaikhoan = idtaikhoan;
        this.sosao = sosao;
        this.ngaydanhgia = ngaydanhgia;
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

    public Double getSosao() {
        return sosao;
    }

    public String getNgaydanhgia() {
        return ngaydanhgia;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdchapter(Integer idchapter) {
        this.idchapter = idchapter;
    }

    public void setIdtaikhoan(Integer idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public void setSosao(Double sosao) {
        this.sosao = sosao;
    }

    public void setNgaydanhgia(String ngaydanhgia) {
        this.ngaydanhgia = ngaydanhgia;
    }

    public DanhGiaDto() {
    }
}