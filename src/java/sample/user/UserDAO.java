/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.ultils.DBUtils;

/**
 *
 * @author flami
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT lastName, roleID "
                        + "FROM Registration "
                        + "WHERE userID =? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String lastName = rs.getString("lastName");
                    Boolean roleID = rs.getBoolean("roleID");
                    user = new UserDTO(userID, lastName, roleID, password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, lastName, roleID, password "
                        + "FROM Registration "
                        + "WHERE lastName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String lastName = rs.getString("lastName");
                    boolean roleID = rs.getBoolean("roleID");
                    String password = rs.getString("password");
                    list.add(new UserDTO(userID, lastName, roleID, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return list;
    }

    public static boolean deleteUser(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE Registration "
                        + "WHERE userID =?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                int value = stm.executeUpdate();
                result = value > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean updateUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE Registration SET "
                        + "lastName=?, roleID=? "
                        + "WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getLastName());
                stm.setBoolean(2, user.getRoleID());
                stm.setString(3, user.getUserID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID FROM Registration WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO "
                        + "Registration(userID, lastName ,roleID, password) "
                        + "VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getLastName());
                stm.setBoolean(3, user.getRoleID());
                stm.setString(4, user.getPassword());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            log("Error at Insert: "+e.toString());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
