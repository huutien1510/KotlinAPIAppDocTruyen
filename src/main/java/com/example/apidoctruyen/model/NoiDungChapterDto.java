package com.example.apidoctruyen.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoiDungChapterDto {
    private Integer id;
    private Integer idchapter;
    private String linkanh;

    public Integer getId() {
        return id;
    }

    public Integer getIdchapter() {
        return idchapter;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdchapter(Integer idchapter) {
        this.idchapter = idchapter;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }

    public String getLinkanh() {
        return linkanh;
    }
}
