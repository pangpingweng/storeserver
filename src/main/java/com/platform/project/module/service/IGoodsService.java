package com.platform.project.module.service;

import java.util.List;
import com.platform.project.module.domain.Goods;

/**
 * 货物Service接口
 * 
 */
public interface IGoodsService 
{
    /**
     * 查询货物
     * 
     * @param goodsId 货物主键
     * @return 货物
     */
    public Goods selectGoodsByGoodsId(Long goodsId);

    /**
     * 查询货物列表
     * 
     * @param goods 货物
     * @return 货物集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增货物
     * 
     * @param goods 货物
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改货物
     * 
     * @param goods 货物
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除货物
     * 
     * @param goodsIds 需要删除的货物主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsIds(Long[] goodsIds);

    /**
     * 删除货物信息
     * 
     * @param goodsId 货物主键
     * @return 结果
     */
    public int deleteGoodsByGoodsId(Long goodsId);
}
