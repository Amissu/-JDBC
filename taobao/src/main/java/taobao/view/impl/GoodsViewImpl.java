package taobao.view.impl;

import java.util.List;
import java.util.Scanner;

import taobao.dao.GoodsDao;
import taobao.dao.impl.GoodsDaoImpl;
import taobao.po.Goods;
import taobao.view.GoodsView;

public class GoodsViewImpl implements GoodsView{

    private Scanner input = new Scanner(System.in);

    @Override
    public List<Goods> showFoodList(Integer businessId) {
        GoodsDao dao = new GoodsDaoImpl();
        List<Goods> list = dao.listFoodByBusinessId(businessId);
        System.out.println("商品编号\t商品名称\t商品介绍\t商品价格");
        for(Goods food : list) {
            System.out.println(food.getFoodId()+"\t"+food.getFoodName()+"\t"+food.getFoodExplain()+"\t"+food.getFoodPrice());
        }
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        Goods food = new Goods();
        System.out.println("请输入商品名称：");
        food.setFoodName(input.next());
        System.out.println("请输入商品介绍：");
        food.setFoodExplain(input.next());
        System.out.println("请输入商品价格：");
        food.setFoodPrice(input.nextDouble());
        food.setBusinessId(businessId);

        GoodsDao dao = new GoodsDaoImpl();
        int result = dao.saveFood(food);
        if(result>0) {
            System.out.println("\n新增商品成功！\n");
        }else {
            System.out.println("\n新增商品失败！\n");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        GoodsDao dao = new GoodsDaoImpl();
        List<Goods> list = showFoodList(businessId);

        if(list.size()==0) {
            System.out.println("没有任何商品！");
        }else {
            System.out.println("请选择要更新的商品编号：");
            int foodId = input.nextInt();
            Goods food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新商品名称(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的商品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新商品介绍(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的商品介绍：");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新商品价格(y/n)：");
            inputStr = input.next();
            if(inputStr.equals("y")) {
                System.out.println("请输入新的商品价格：");
                food.setFoodPrice(input.nextDouble());
            }

            int result = dao.updateFood(food);
            if(result>0) {
                System.out.println("\n修改商品成功！\n");
            }else {
                System.out.println("\n修改商品失败！\n");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        GoodsDao dao = new GoodsDaoImpl();
        List<Goods> list = showFoodList(businessId);

        if(list.size()==0) {
            System.out.println("没有任何商品！");
        }else {
            System.out.println("请选择要删除的商品编号：");
            int foodId = input.nextInt();

            System.out.println("确认要删除吗(y/n)：");
            if(input.next().equals("y")) {
                int result = dao.removeFood(foodId);
                if(result>0) {
                    System.out.println("\n删除商品成功！\n");
                }else {
                    System.out.println("\n删除商品失败！\n");
                }
            }
        }
    }
}