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
import tinlt.dtos.HistoryDTO;
import tinlt.dtos.UserDTO;

/**
 *
 * @author Ray Khum
 */
public class UserDAO {

    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UserDTO CheckLogin(String userName, String password) throws SQLException {
        UserDTO user = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();

            if (cn != null) {
                String sql = "SELECT [userName],[fullName],[password],[role]\n"
                        + "FROM tblCustomer\n"
                        + "WHERE userName = ? and password = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String userName1 = rs.getString("userName");
                    String fullName = rs.getString("fullName");
                    String password1 = rs.getString("password");
                    boolean role = rs.getBoolean("role");
                    user = new UserDTO(userName1, fullName, password1, role);
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
        return user;
    }

    public List<HistoryDTO> GetHistory(String userName, String Name, String BuyDate) throws SQLException {
        List<HistoryDTO> list = null;
        HistoryDTO dto = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = tinlt.utils.DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT C.[userName],O.[buyDate], P.proName, P.proImage, A.numOfProduct, A.totalPrice\n"
                        + "FROM [dbo].[tblCustomer] C,[dbo].[tblOrder] O,[dbo].[tblProducts] P,[dbo].[tblOrderCart] A\n"
                        + "WHERE C.userName = ? AND \n"
                        + "		O.orderID = A.orderID AND\n"
                        + "		A.proID = P.proID AND \n"
                        + "		P.proName like ? AND\n"
                        + "		O.buyDate like ?; ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, "%"+Name+"%");
                pst.setString(3, "%"+BuyDate+"%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String NameID = rs.getString("userName");
                    String buyDate = rs.getString("buyDate");
                    String proName = rs.getString("proName");
                    String proImage = rs.getString("proImage");
                    int numOfPro = rs.getInt("numOfProduct");
                    float price = rs.getFloat("totalPrice");

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new HistoryDTO(NameID, buyDate, proName, proImage, numOfPro, price);
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

}
