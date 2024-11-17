package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Lichsudoctruyen;
import com.example.apidoctruyen.entity.Truyen;

import com.example.apidoctruyen.model.ChapterDto;

import com.example.apidoctruyen.model.TimkiemModel;

import com.example.apidoctruyen.model.TruyenDto;
import com.example.apidoctruyen.model.TruyenInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface truyenRepository extends JpaRepository<Truyen, Integer> {
    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search)\n" +
            "FROM Truyen t")
    List<TruyenDto> getAllTruyen();
//    @Query(value = "SELECT TOP 4 truyen.*, chapter.id AS chapter_id, chapter.idtruyen AS chapter_idtruyen, chapter.tenchapter AS chapter_tenchapter, chapter.ngaydang AS chapter_ngaydang " +
//            "FROM truyen " +
//            "INNER JOIN chapter ON truyen.id = chapter.idtruyen " +
//            "WHERE chapter.tenchapter = 'Chapter 1' " +
//            "ORDER BY chapter.ngaydang DESC",
//            nativeQuery = true)
//    List<Truyen> getTruyenMoi();

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY c.ngaydang DESC")
    List<TruyenDto> getTruyenMoi(Pageable pageable);
    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search) " +
            "FROM Truyen t\n" +
            "JOIN t.thongkes tk\n" +
            "ORDER BY tk.tongluotxem DESC")
    List<TruyenDto> getTopTruyen(Pageable pageable);


    @Query(value = "SELECT DISTINCT t.theloai FROM Truyen t")
    List<String> findAllTheLoai();

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY c.ngaydang DESC")
    List<TruyenInfo> findNewestBooks();


    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY c.ngaydang DESC")
    List<TruyenInfo> findNewestComics();
    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search)\n" +
            "FROM Truyen t\n" +
            " where t.id = :id" )
    List<TruyenDto> getTruyenBy(int id);

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai\n" +
            "ORDER BY c.ngaydang DESC")
    List<TruyenInfo> findNewestComicsByTheLoai(String theloai);

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +

            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY tk.sosaotb DESC, c.ngaydang DESC")
    List<TruyenInfo> findVotesComic();

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai\n" +
            "ORDER BY tk.sosaotb DESC, c.ngaydang DESC")
    List<TruyenInfo> findVotesComicByTheLoai(String theloai);

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1'\n" +
            "ORDER BY tk.tongluotxem DESC, c.ngaydang DESC")
    List<TruyenInfo> findViewComic();

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh)\n" +
            "FROM Truyen t\n" +
            "JOIN t.chapters c\n" +
            "JOIN t.thongkes tk\n" +
            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai\n" +
            "ORDER BY tk.tongluotxem DESC, c.ngaydang DESC")
    List<TruyenInfo> findViewComicByTheLoai(String theloai);

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search)\n" +
            "FROM Truyen t\n" +

            "JOIN t.chapters c\n" +
            "WHERE c.id = :idchapter")
    TruyenDto getOneTruyen(int idchapter);

    @Query("SELECT new com.example.apidoctruyen.model.TimkiemModel(t.id, tk.tongluotxem, c.id, tk.sosaotb, t.tentruyen, t.theloai, t.linkanh) \n" +
            "FROM Truyen t \n" +
            "JOIN t.thongkes tk \n" +
            "JOIN t.chapters c \n" +
            "WHERE LOWER(t.key_search) LIKE LOWER(CONCAT('%', :textsearch, '%')) \n" +
            "GROUP BY t.id, tk.tongluotxem, c.id, tk.sosaotb, t.tentruyen, t.theloai, t.linkanh \n" +
            "ORDER BY tk.tongluotxem DESC")
    ArrayList<TimkiemModel> getListTimKiem(String textsearch);

    @Query("SELECT t.id, tk.tongluotxem, COUNT(c.id), tk.sosaotb, t.tentruyen, t.theloai, t.linkanh \n" +
            "FROM Truyen t \n" +
            "JOIN t.thongkes tk \n" +
            "JOIN t.chapters c \n" +
            "WHERE LOWER(t.key_search) LIKE LOWER(CONCAT('%', :textSearch, '%')) \n" +
            "AND t.theloai = :textTheLoai \n" +
            "GROUP BY t.id, tk.tongluotxem, c.id, tk.sosaotb, t.tentruyen, t.theloai, t.linkanh\n" +
            "ORDER BY tk.tongluotxem DESC")
    List<TimkiemModel> getListTimKiemByTheLoai(@Param("textSearch") String textSearch, @Param("textTheLoai") String textTheLoai);

//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//
//    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenInfo (t.id, tk.tongluotxem, tk.sosaotb, t.tentruyen, c.ngaydang, t.theloai, t.linkanh) \n" +
//            "FROM Truyen t \n" +
//            "JOIN Chapter c ON t.id = c.idtruyen.id \n" +
//            "JOIN Thongke tk ON t.id = tk.idtruyen.id \n" +
//            "WHERE c.tenchapter = 'Chapter 1' AND t.theloai = :theloai " +
//            "ORDER BY c.ngaydang DESC")
//    List<TruyenDto> findTruyenByTheloai(@Param("theloai") String theloai, Pageable pageable);
//



    @Query("SELECT t.tentruyen FROM Truyen t")
    List<String> getTenTruyen();

//    @Query("INSERT INTO Truyen (tentruyen, tacgia, mota, theloai, linkanh, key_search) VALUES (:tentruyen, :tacgia, :mota, :theloai, :linkanh, :key_search)")
//    Truyen addTruyen(String tentruyen, String tacgia, String mota, String theloai, String linkanh, String key_search);

    @Query("SELECT NEW com.example.apidoctruyen.model.TruyenDto (t.id, t.tentruyen, t.tacgia, t.mota, t.theloai, t.linkanh, t.trangthai, t.key_search)\n" +
            "FROM Truyen t\n" +
            "WHERE t.id = :id")
    List<TruyenDto> getAllTruyenById(int id);

}
