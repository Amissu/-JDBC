package taobao.view.impl;

import java.util.Scanner;

import taobao.dao.UserDao;
import taobao.dao.impl.UserDaoImpl;
import taobao.po.User;
import taobao.view.UserView;

public class UserViewImpl implements UserView{

    private Scanner input = new Scanner(System.in);

    @Override
    public User login() {
        System.out.println("请输入用户编号：");
        int userId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();

        UserDao dao = new UserDaoImpl();
        return dao.getUserByNameByPass(userId, password);
    }
}
