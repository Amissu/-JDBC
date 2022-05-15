package taobao.view.impl;

import java.util.Scanner;

import taobao.dao.AdminDao;
import taobao.dao.impl.AdminDaoImpl;
import taobao.po.Admin;
import taobao.view.AdminView;

public class AdminViewImpl implements AdminView{

    private Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入管理员名称：");
        String adminName = input.next();
        System.out.println("请输入密码：");
        String password = input.next();

        AdminDao dao = new AdminDaoImpl();
        return dao.getAdminByNameByPass(adminName, password);
    }
}

