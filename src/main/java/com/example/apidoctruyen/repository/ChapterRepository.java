package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Chapter;
import com.example.apidoctruyen.model.ChapterDto;

import com.example.apidoctruyen.model.NoiDungChapterDto;

import com.example.apidoctruyen.model.ChapterModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ChapterRepository extends JpaRepository<Chapter,Integer> {
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (c.id,c.idtruyen.id, c.tenchapter, c.ngaydang, c.soluotxem, c.danhgia)\n" +
            "FROM Chapter c\n" +
            "WHERE c.idtruyen.id = :id")
    List<ChapterDto> getChapterByIdTruyen(int id);


    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (c.id,c.idtruyen.id, c.tenchapter, c.ngaydang, c.soluotxem, c.danhgia)\n" +
            "FROM Chapter c\n" +
            "WHERE c.id = :id")
    List<ChapterDto> getChapterContentById(int id);

    //select * from noidungchapter where idchapter="+id
    @Query("SELECT NEW com.example.apidoctruyen.model.NoiDungChapterDto (c.id,c.idchapter.id,c.linkanh)\n" +
            "FROM Noidungchapter c\n" +
            "WHERE c.idchapter.id = :id")
    List<NoiDungChapterDto> getLinkChapterById(int id);



    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto(c.id, c.idtruyen.id, c.tenchapter,c.ngaydang, c.soluotxem, c.danhgia)\n" +
            "FROM Chapter c\n" +
            "WHERE c.id=:idchapter")
    ChapterDto getOneChapter(int idchapter);

    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterModel (c.id, c.idtruyen.id, c.soluotxem,c.danhgia,c.tenchapter,c.ngaydang)\n" +
            "FROM Chapter c\n" +
            "WHERE c.idtruyen.id = :id")
    List<ChapterModel> getChapterById(int id);

    @Query("SELECT c.tenchapter\n" +
            "FROM Chapter c\n" +
            "JOIN c.idtruyen t\n" +
            "WHERE t.id = :idtruyen\n" +
            "ORDER BY c.id desc limit 1 ")
    String getTenChapterNew(int idtruyen);

    @Query("SELECT c.idtruyen.id\n" +
            "FROM Chapter c\n" +
            "WHERE c.id = :id")
    int getIdTruyenByIdChapter(int id);
    @Query("SELECT SUM(c.soluotxem) FROM Chapter c WHERE c.idtruyen.id = :idtruyen")
    Long sumSoluotxemByTruyenId(int idtruyen);
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (t.id, t.idtruyen.id, t.tenchapter, t.ngaydang, t.soluotxem, t.danhgia)\n" +
            "FROM Chapter t\n" +
            " where t.idtruyen.id = :id" )
    List<ChapterDto> getChapterByIdT(int id);
    @Query("SELECT NEW com.example.apidoctruyen.model.ChapterDto (t.id, t.idtruyen.id, t.tenchapter, t.ngaydang, t.soluotxem, t.danhgia)\n FROM Chapter t WHERE t.id = :id")
    List<ChapterDto> findTenById(int id);

    @Query("select c.id from Chapter c where c.idtruyen.id=:id and c.tenchapter='Chapter 1'")

    int getMinIdChapter(int id);
    @Query("select c.id from Chapter c where c.idtruyen.id=:id order by c.id desc limit 1")

    int getMaxIdChapter(int id);

}
