package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Noidungchapter;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.ChapterDto;
import com.example.apidoctruyen.model.NoiDungChapterDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoiDungChapterRepository extends JpaRepository<Noidungchapter, Integer> {
    @Query("SELECT NEW com.example.apidoctruyen.model.NoiDungChapterDto (t.id, t.idchapter.id, t.linkanh) \n" +
            "FROM Noidungchapter t \n" +
            "WHERE t.idchapter.id = :id")
    List<NoiDungChapterDto> getNoidungchapterById( int id);

}
