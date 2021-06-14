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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import tinlt.dtos.ProductDTO;

/**
 *
 * @author Ray Khum
 */
public class ProductDAO {

    public boolean CreateProduce(ProductDTO pro) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT into [dbo].[tblProducts]([proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID])\n"
                        + "VALUES(?,?,?,?,?,?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, pro.getProName());
                pst.setFloat(2, pro.getProPrice());
                pst.setInt(3, pro.getQuantity());
                pst.setString(4, pro.getDescription());
                pst.setString(5, pro.getProImage());
                pst.setBoolean(6, pro.isStatus());
                pst.setString(7, pro.getCreateDate());
                pst.setString(8, pro.getExpiryDate());
                pst.setString(9, pro.getCategoryID());
                pst.executeUpdate();
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public List<ProductDTO> GetProduct(int index) throws SQLException {
        List<ProductDTO> list = null;
        ProductDTO dto = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [proID],[proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID]\n"
                        + "FROM [dbo].[tblProducts]\n"
                        + "ORDER BY categoryID ASC\n"
                        + "OFFSET 15*? ROWS\n"
                        + "FETCH NEXT 15 ROWS ONLY";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, index);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int proID = rs.getInt("proID");
                    String proName = rs.getString("proName");
                    float proPrice = rs.getFloat("proPrice");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String proImage = rs.getString("proImage");
                    boolean status = rs.getBoolean("status");
                    String createDate = rs.getString("createDate");
                    String expiryDate = rs.getString("expiryDate");
                    String categoryID = rs.getString("categoryID");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ProductDTO(proID, proName, proPrice, quantity, description, proImage, status, createDate, expiryDate, categoryID);
                    list.add(dto);
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

    public List<ProductDTO> GetProductTrue(int index) throws SQLException {
        List<ProductDTO> list = null;
        ProductDTO dto = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [proID],[proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID]\n"
                        + "FROM [dbo].[tblProducts]\n"
                        + "WHERE status = 1 "
                        + "ORDER BY categoryID ASC\n"
                        + "OFFSET 15*? ROWS\n"
                        + "FETCH NEXT 15 ROWS ONLY";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, index);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int proID = rs.getInt("proID");
                    String proName = rs.getString("proName");
                    float proPrice = rs.getFloat("proPrice");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String proImage = rs.getString("proImage");
                    boolean status = rs.getBoolean("status");
                    String createDate = rs.getString("createDate");
                    String expiryDate = rs.getString("expiryDate");
                    String categoryID = rs.getString("categoryID");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ProductDTO(proID, proName, proPrice, quantity, description, proImage, status, createDate, expiryDate, categoryID);
                    list.add(dto);
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

    public int CountProduct() throws SQLException {
        int count = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) as [count]\n"
                        + "FROM [dbo].[tblProducts]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } catch (Exception e) {
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
        return count;
    }

    public List<ProductDTO> GetSearchProduct(String index, String name, String cateID, String minPrice, String maxPrice)
            throws SQLException, NamingException {
        List<ProductDTO> list = null;
        ProductDTO dto = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [proID], [proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID]\n "
                        + "FROM [dbo].[tblProducts]\n "
                        + "WHERE [proName] LIKE ? AND [proPrice] BETWEEN ? AND ? AND [categoryID] LIKE ? "
                        + "ORDER BY categoryID ASC\n "
                        + "OFFSET 15*? ROWS\n "
                        + "FETCH NEXT 15 ROWS ONLY ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setString(2, minPrice);
                pst.setString(3, maxPrice);
                pst.setString(4, "%" + cateID + "%");
                pst.setString(5, index);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int proID = rs.getInt("proID");
                    String proName = rs.getString("proName");
                    float proPrice = rs.getFloat("proPrice");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String proImage = rs.getString("proImage");
                    boolean status = rs.getBoolean("status");
                    String createDate = rs.getString("createDate");
                    String expiryDate = rs.getString("expiryDate");
                    String categoryID = rs.getString("categoryID");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ProductDTO(proID, proName, proPrice, quantity, description, proImage, status, createDate, expiryDate, categoryID);
                    list.add(dto);
                }
            }
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

    public List<ProductDTO> GetSearchProductTrue(String index, String name, String cateID, String minPrice, String maxPrice)
            throws SQLException, NamingException {
        List<ProductDTO> list = null;
        ProductDTO dto = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [proID], [proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID]\n "
                        + "FROM [dbo].[tblProducts]\n "
                        + "WHERE [proName] LIKE ? AND [proPrice] BETWEEN ? AND ? AND [categoryID] LIKE ?  AND status = 1 "
                        + "ORDER BY categoryID ASC\n "
                        + "OFFSET 15*? ROWS\n "
                        + "FETCH NEXT 15 ROWS ONLY ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setString(2, minPrice);
                pst.setString(3, maxPrice);
                pst.setString(4, "%" + cateID + "%");
                pst.setString(5, index);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int proID = rs.getInt("proID");
                    String proName = rs.getString("proName");
                    float proPrice = rs.getFloat("proPrice");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String proImage = rs.getString("proImage");
                    boolean status = rs.getBoolean("status");
                    String createDate = rs.getString("createDate");
                    String expiryDate = rs.getString("expiryDate");
                    String categoryID = rs.getString("categoryID");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ProductDTO(proID, proName, proPrice, quantity, description, proImage, status, createDate, expiryDate, categoryID);
                    list.add(dto);
                }
            }
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

    public int CountSearchProduct(String name, String cateID, String minPrice, String maxPrice) throws SQLException {
        int count = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cn = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) as count "
                        + "FROM [dbo].[tblProducts] "
                        + "WHERE [proName] LIKE ? AND [proPrice] BETWEEN ? AND ? AND [categoryID] LIKE ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setString(2, minPrice);
                pst.setString(3, maxPrice);
                pst.setString(4, "%" + cateID + "%");
                rs = pst.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } catch (Exception e) {
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
        return count;
    }

    public int CountSearchProductTrue(String name, String cateID, String minPrice, String maxPrice) throws SQLException {
        int count = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cn = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT COUNT(*) as count "
                        + "FROM [dbo].[tblProducts] "
                        + "WHERE [proName] LIKE ? AND [proPrice] BETWEEN ? AND ? AND [categoryID] LIKE ? AND status =1 ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                pst.setString(2, minPrice);
                pst.setString(3, maxPrice);
                pst.setString(4, "%" + cateID + "%");
                rs = pst.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("count");
                }
            }
        } catch (Exception e) {
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
        return count;
    }

    public int GetProID() throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int proID = 0;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT MAX([proID]) as MaxProID\n "
                        + "FROM [dbo].[tblProducts] ";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    proID = rs.getInt("MaxProID");
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
        return proID;
    }

    public boolean DeleteProduct(String proID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "update [dbo].[tblProducts]\n "
                        + "set [status] = 0\n "
                        + "where [proID] = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, proID);
                check = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public boolean DeleteLog(String proID, String userName) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;

        Date date = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String ngay = Format.format(date);

        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO  [dbo].[tblUpdateLogs]([proID],[userName],[updateDate],[isUpdate])\n"
                        + "VALUES (?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, proID);
                pst.setString(2, userName);
                pst.setString(3, ngay);
                pst.setBoolean(4, false);
                check = pst.executeUpdate() > 0;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public ProductDTO GetProByID(String productID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [proID],[proName],[proPrice],[quantity],[description],[proImage],[status],[createDate],[expiryDate],[categoryID]\n "
                        + "FROM [dbo].[tblProducts]\n "
                        + "WHERE proID = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, productID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int proID = rs.getInt("proID");
                    String proName = rs.getString("proName");
                    float proPrice = rs.getFloat("proPrice");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String proImage = rs.getString("proImage");
                    boolean status = rs.getBoolean("status");
                    String createDate = rs.getString("createDate");
                    String expiryDate = rs.getString("expiryDate");
                    String categoryID = rs.getString("categoryID");
                    dto = new ProductDTO(proID, proName, proPrice, quantity, description, proImage, status, createDate, expiryDate, categoryID);
                }
            }
        } catch (Exception e) {
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
        return dto;
    }

    public boolean UpdateProduct(ProductDTO pro) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[tblProducts]\n"
                        + "SET [proName] = ?, [proPrice] = ?, [quantity] = ?, [description] = ?, [proImage] = ?, [status] = ?, [createDate] = ?, [expiryDate] = ?, [categoryID] = ?\n"
                        + "WHERE [proID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, pro.getProName());
                pst.setFloat(2, pro.getProPrice());
                pst.setInt(3, pro.getQuantity());
                pst.setString(4, pro.getDescription());
                pst.setString(5, pro.getProImage());
                pst.setBoolean(6, pro.isStatus());
                pst.setString(7, pro.getCreateDate());
                pst.setString(8, pro.getExpiryDate());
                pst.setString(9, pro.getCategoryID());
                pst.setInt(10, pro.getProID());
                check = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public boolean UpdateLogs(String proID, String userName) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;

        Date date = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String ngay = Format.format(date);

        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO  [dbo].[tblUpdateLogs]([proID],[userName],[updateDate],[isUpdate])\n"
                        + "VALUES (?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, proID);
                pst.setString(2, userName);
                pst.setString(3, ngay);
                pst.setBoolean(4, true);
                check = pst.executeUpdate() > 0;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public boolean SetQuantityProduct(int quantity, int proID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[tblProducts]\n"
                        + "SET [quantity] = ?\n " 
                        + "WHERE [proID] = ? ";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, quantity);
                pst.setInt(2, proID);
                check = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

}
