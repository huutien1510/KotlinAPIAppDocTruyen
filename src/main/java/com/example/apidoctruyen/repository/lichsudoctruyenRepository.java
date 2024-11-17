package com.example.apidoctruyen.repository;

import com.example.apidoctruyen.entity.Lichsudoctruyen;
import com.example.apidoctruyen.model.LichsudoctruyenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface lichsudoctruyenRepository extends JpaRepository<Lichsudoctruyen, Integer> {

    @Query("SELECT NEW com.example.apidoctruyen.model.LichsudoctruyenModel(t.id, c.id, tk.id) " +
            "FROM Lichsudoctruyen t " +
            "JOIN t.idchapter c\n" +
            "JOIN t.idtaikhoan tk\n" +
            "WHERE t.idtaikhoan.id = :idtaikhoan")
    List<LichsudoctruyenModel> getListTruyenDaDoc(@Param("idtaikhoan") int idtaikhoan);


}
