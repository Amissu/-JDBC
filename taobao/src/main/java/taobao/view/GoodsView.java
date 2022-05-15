package taobao.view;

import java.util.List;

import taobao.po.Goods;

public interface GoodsView {

    public List<Goods> showFoodList(Integer businessId);
    public void saveFood(Integer businessId);
    public void updateFood(Integer businessId);
    public void removeFood(Integer businessId);
}
