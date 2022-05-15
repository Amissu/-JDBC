package taobao.dao;

import taobao.po.User;

public interface UserDao {
    public User getUserByNameByPass(Integer userId, String password);
}
