package taobao;

import java.util.Scanner;

import taobao.po.Business;
import taobao.view.BusinessView;
import taobao.view.GoodsView;
import taobao.view.impl.BusinessViewImpl;
import taobao.view.impl.GoodsViewImpl;

public class TaobaoBusinessEntry {

    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 淘宝后台管理系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        BusinessView businessView = new BusinessViewImpl();

        //商家登录
        Business business = businessView.login();

        if(business!=null) {
            int menu = 0;
            while(menu!=5) {
                //输出一级菜单
                System.out.println("\n======= 一级菜单（商家管理）1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统=======");
                System.out.println("请输入你的选择：");
                menu = input.nextInt();

                switch(menu) {
                    case 1:
                        businessView.showBusiness(business.getBusinessId());
                        break;
                    case 2:
                        businessView.editBusiness(business.getBusinessId());
                        break;
                    case 3:
                        businessView.updateBusinessByPassword(business.getBusinessId());
                        break;
                    case 4:
                        foodManager(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临饿了么后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }
        }else {
            System.out.println("商家编号或密码输入错误！");
        }

    }

    private void foodManager(int businessId) {
        Scanner input = new Scanner(System.in);

        GoodsView foodView = new GoodsViewImpl();

        int menu = 0;
        while(menu!=5) {
            //输出二级菜单
            System.out.println("\n======= 二级菜单（商品管理）1.查看商品列表=2.新增商品=3.修改商品=4.删除商品=5.返回一级菜单 =======");
            System.out.println("请输入你的选择：");
            menu = input.nextInt();

            switch(menu) {
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.saveFood(businessId);
                    break;
                case 3:
                    foodView.updateFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new TaobaoBusinessEntry().work();
    }
}

