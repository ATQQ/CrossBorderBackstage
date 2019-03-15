package sugar.service;

import sugar.bean.Goods;

import java.util.List;

public interface goodsService {
    /**
     * 新增货品信息
     * @param goods
     * @return 增加成功True 否则false
     */
    public boolean addGoods(Goods goods);

    /**
     * 获取商家货物列表
     * @param username
     * @return
     */
    public List<Goods> selectGoods(String username);

    /**
     * 首页获取商品列表
     * @param content ($home或likeText)
     * @return
     */
    public List<Goods> getGoods(String content);
}
