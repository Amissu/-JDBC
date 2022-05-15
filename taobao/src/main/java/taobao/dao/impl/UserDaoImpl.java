package taobao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import taobao.dao.UserDao;
import taobao.po.User;
import taobao.util.DBUtil;

public class UserDaoImpl implements UserDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public User getUserByNameByPass(Integer userId, String password) {
        User user = null;
        String sql = "select * from user where userId=? and password=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while(rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return user;
    }
}
