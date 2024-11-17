package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Binhluan;
import com.example.apidoctruyen.entity.Truyen;
import com.example.apidoctruyen.model.BinhLuanTruyenDto;
import com.example.apidoctruyen.model.TruyenInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BinhLuanRepository extends JpaRepository<Binhluan, Integer> {
    @Query("SELECT new com.example.apidoctruyen.model.BinhLuanTruyenDto(c.linkanh, c.email, b.noidung, b.ngaydang, ch.tenchapter)\n" +
            "FROM Binhluan b\n" +
            "JOIN b.idtaikhoan c \n" +
            "JOIN b.idchapter ch \n" +
            "WHERE b.trangthai = 1 AND ch.idtruyen.id = :id\n" +
            "ORDER BY b.ngaydang DESC")
    List<BinhLuanTruyenDto> getBinhLuan(int id);
    @Query("SELECT COUNT(b) FROM Binhluan b JOIN b.idchapter ch WHERE ch.idtruyen.id = :idtruyen")
    Long countBinhLuanByTruyenId(int idtruyen);
    @Query("SELECT new com.example.apidoctruyen.model.BinhLuanTruyenDto(c.linkanh, c.email, b.noidung, b.ngaydang, ch.tenchapter)\n" +
            "FROM Binhluan b\n" +
            "JOIN b.idtaikhoan c \n" +
            "JOIN b.idchapter ch \n" +
            "WHERE b.trangthai = 1 AND ch.id = :id\n" +
            "ORDER BY b.ngaydang DESC")
    List<BinhLuanTruyenDto> getBinhLuanTheoIdChapter(int id);

    @Query(value = "INSERT INTO binhluan (idchapter, idtaikhoan, noidung, ngaydang, trangthai) " +
            "VALUES (:idchapter, :idtaikhoan, :noidung, :ngaydang, :trangthai); " +
            "SELECT SCOPE_IDENTITY()",
            nativeQuery = true)
    Integer addBinhLuan(Integer idchapter, Integer idtaikhoan, String noidung, LocalDate ngaydang, Integer trangthai);


}
