package taobao.dao;

import taobao.po.Admin;

public interface AdminDao {

    public Admin getAdminByNameByPass(String adminName,String password);
}
