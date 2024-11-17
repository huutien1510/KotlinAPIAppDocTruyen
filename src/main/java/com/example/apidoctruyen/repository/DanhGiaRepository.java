package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Binhluan;
import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.model.TruyenDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DanhGiaRepository extends JpaRepository<Danhgia, Integer> {
    @Query("SELECT round(avg(d.sosao), 2) FROM Danhgia d WHERE d.idchapter.id IN (SELECT c.id FROM Chapter c WHERE c.idtruyen.id = :idtruyen)")
    Double getAverageRatingByTruyenId(int idtruyen);

    @Query("select c.id from Danhgia c where c.idchapter.id=:idchapter and c.idtaikhoan.id=:idtaikhoan")
    List<Integer> getIDByChapterAndTK(int idchapter, int idtaikhoan);
    @Modifying
    @Query("UPDATE Danhgia d SET d.sosao = :sosao WHERE d.idchapter = :idchapter AND d.idtaikhoan = :idtaikhoan")
    int updateDanhGia(@Param("idchapter") int idchapter, @Param("idtaikhoan") int idtaikhoan, @Param("sosao") double sosao);

    @Query("SELECT round(avg(d.sosao), 2) FROM Danhgia d WHERE d.idchapter.id = :id")
    Double getAverageRatingByIdChapter(@Param("id") int id);

    @Query("SELECT round(avg(d.sosao), 2) FROM Danhgia d WHERE d.idchapter.id = : idchapter")
    Double getAverageRatingByIdChapter(Integer idchapter);
    //Optional<Danhgia> findByIdChapterAndIdTaiKhoan(Integer idChapter, Integer idTaiKhoan);



    // updateDanhGia
    @Query("UPDATE Danhgia d SET d.sosao = :sosao WHERE d.idchapter.id = :idchapter AND d.idtaikhoan.id = :idtaikhoan")
    void updateDanhGia(Integer idchapter, Integer idtaikhoan, Integer sosao);

    @Query("SELECT d FROM Danhgia d WHERE d.idchapter.id = :idchapter AND d.idtaikhoan.id = :idtaikhoan")
    Danhgia findByIdchapterAndIdtaikhoan(Integer idchapter, Integer idtaikhoan);

    @Query(value = "INSERT INTO Danhgia (idchapter, idtaikhoan, sosao, ngaydanhgia) " +
            "VALUES (:idchapter, :idtaikhoan, :sosao, :ngaydanhgia); " +
            "SELECT SCOPE_IDENTITY()",
            nativeQuery = true)
    Integer addDanhGia(Integer idchapter, Integer idtaikhoan,Double sosao, LocalDate ngaydanhgia);

}
