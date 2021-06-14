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
import java.util.Date;

/**
 *
 * @author Ray Khum
 */
public class CartDAO {

    public boolean InsertOrderCart(String cartPrice, String UserName) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;

        Date date = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String ngay = Format.format(date);

        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[tblOrder]([cartPrice],[userName],[buyDate])\n "
                        + "VALUES (?, ?, ?) ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, cartPrice);
                pst.setString(2, UserName);
                pst.setString(3, ngay);
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

    public int GetMaxOderID() throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int orderID = 0;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT MAX([orderID]) as MaxOrderID\n"
                        + "from [dbo].[tblOrder]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("MaxOrderID");
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
        return orderID;
    }

    public boolean InsertOrderDetail(int proID, int numOfPro, float totalPrice) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        CartDAO dao = new CartDAO();
        int orderID = dao.GetMaxOderID();
        boolean check = false;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[tblOrderCart]([proID],[orderID],[numOfProduct],[totalPrice])\n"
                        + "VALUES (?, ?, ?, ?) ";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, proID);
                pst.setInt(2, orderID);
                pst.setInt(3, numOfPro);
                pst.setFloat(4, totalPrice);
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
