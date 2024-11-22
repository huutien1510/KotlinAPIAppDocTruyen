package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Danhgia;
import com.example.apidoctruyen.model.BinhLuanCuaToi;
import com.example.apidoctruyen.model.DanhGiaCuaToiDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DanhGiaCuaToiRepository extends JpaRepository<Danhgia, Integer> {
    @Query("SELECT NEW com.example.apidoctruyen.model.DanhGiaCuaToiDto( " +
            "tk.id, " +
            "ch.idtruyen.tentruyen AS tenTruyen, " +
            "ch.tenchapter AS tenChapter, " +
            "tk.sosao, " +
            "tk.ngaydanhgia, " +
            "ch.idtruyen.linkanh AS linkAnh, " +
            "tk.idtaikhoan.id AS idtaikhoan) " +
            "FROM Danhgia tk " +
            "JOIN tk.idchapter ch " +
            "WHERE tk.idtaikhoan.id = :idtaikhoan")
    List<DanhGiaCuaToiDto> findByIdn(@Param("idtaikhoan") Integer idtaikhoan);
}

