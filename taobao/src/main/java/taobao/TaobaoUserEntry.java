package taobao;

import java.util.Scanner;

import taobao.po.User;
import taobao.view.UserView;
import taobao.view.CommentView;
import taobao.view.impl.UserViewImpl;
import taobao.view.impl.CommentViewImpl;

public class TaobaoUserEntry {

    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 淘宝用户评论区  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        UserView userView = new UserViewImpl();
        CommentView commentView = new CommentViewImpl();
        User user = userView.login();

        //登录
        if(user!=null) {
            int menu = 0;
            while(menu!=5) {
                //输出主菜单
                System.out.println("\n========= 1.显示所以评论=2.查找评论=3.新建评论=4.修改评论=5.删除评论=6.查看自己评论=7.退出系统 =========");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();
                switch(menu) {
                    case 1:
                        commentView.ListCommentAll();
                        break;
                    case 2:
                        commentView.ListComment();
                        break;
                    case 3:
                        commentView.saveComment(user.getUserId());
                        break;
                    case 4:
                        commentView.updateComment(user.getUserId());
                        break;
                    case 5:
                        commentView.removeComment(user.getUserId());
                        break;
                    case 6:
                        commentView.showCommentList(user.getUserId());
                        break;
                    case 7:
                        System.out.println("------------------------欢迎下次光临淘宝用户评论区-----------------------");
                        break;

                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }

        }else {
            System.out.println("\n用户名称或密码输入错误!\n");
        }
    }

    public static void main(String[] args) {
        new TaobaoUserEntry().work();
    }
}

