//package com.example.apidoctruyen.repository;
//
//import com.example.apidoctruyen.model.TimkiemModel;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface timkiemRepository extends JpaRepository<TimkiemModel, Integer> {
//
//
//    @Query("SELECT t.id, tk.tongluotxem, COUNT(c.id), tk.sosaotb, t.tentruyen, t.theloai, t.linkanh " +
//            "FROM Truyen t " +
//            "JOIN t.thongkes tk " +
//            "JOIN t.chapters c " +
//            "WHERE LOWER(t.key_search) LIKE LOWER(CONCAT('%', :textSearch, '%')) " +
//            "GROUP BY t.id " +
//            "ORDER BY tk.tongluotxem DESC")
//    List<TimkiemModel> findTruyenBySearchText(@Param("textSearch") String textSearch);
//
//    @Query("SELECT t.id, tk.tongluotxem, COUNT(c.id), tk.sosaotb, t.tentruyen, t.theloai, t.linkanh " +
//            "FROM Truyen t " +
//            "JOIN t.thongkes tk " +
//            "JOIN t.chapters c " +
//            "WHERE LOWER(t.key_search) LIKE LOWER(CONCAT('%', :textSearch, '%')) " +
//            "AND t.theloai = :textTheLoai " +
//            "GROUP BY t.id " +
//            "ORDER BY tk.tongluotxem DESC")
//    List<Object[]> findTruyenBySearchTextAndTheLoai(@Param("textSearch") String textSearch, @Param("textTheLoai") String textTheLoai);
//
//}
