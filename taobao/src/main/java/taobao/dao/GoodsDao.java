package taobao.dao;

import java.util.List;


import taobao.po.Goods;

public interface GoodsDao {

    public List<Goods> listFoodByBusinessId(Integer businessId);
    public int saveFood(Goods food);
    public Goods getFoodById(Integer foodId);
    public int updateFood(Goods food);
    public int removeFood(Integer foodId);
}
