/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tinlt.dtos.CategoryDTO;

/**
 *
 * @author Ray Khum
 */
public class CategoryDAO {

    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<CategoryDTO> GetCategory() throws SQLException {
        CategoryDTO cate = null;
        List<CategoryDTO> list = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT categoryID, category FROM tblcategorys";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String typeID = rs.getString("categoryID");
                    String typeProduct = rs.getString("category");
                    cate = new CategoryDTO(typeID, typeProduct);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(cate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }
}
