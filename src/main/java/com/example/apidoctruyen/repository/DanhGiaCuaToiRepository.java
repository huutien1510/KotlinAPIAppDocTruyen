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
    @Query("select NEW com.example.apidoctruyen.model.DanhGiaCuaToiDto(tk.id,tk.idchapter.id,tk.idtaikhoan.id,tk.sosao,tk.ngaydanhgia) from Danhgia tk where tk.idtaikhoan.id = :idtaikhoan")
    public List<DanhGiaCuaToiDto> findByIdn(@Param("idtaikhoan") Integer idtaikhoan);
}
