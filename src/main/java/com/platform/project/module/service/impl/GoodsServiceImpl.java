package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.GoodsMapper;
import com.platform.project.module.domain.Goods;
import com.platform.project.module.service.IGoodsService;

/**
 * 货物Service业务层处理
 * 
 */
@Service
public class GoodsServiceImpl implements IGoodsService 
{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询货物
     * 
     * @param goodsId 货物主键
     * @return 货物
     */
    @Override
    public Goods selectGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.selectGoodsByGoodsId(goodsId);
    }

    /**
     * 查询货物列表
     * 
     * @param goods 货物
     * @return 货物
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 新增货物
     * 
     * @param goods 货物
     * @return 结果
     */
    @Transactional
    @Override
    public int insertGoods(Goods goods)
    {
        goods.setCreateTime(DateUtils.getNowDate());
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改货物
     * 
     * @param goods 货物
     * @return 结果
     */
    @Transactional
    @Override
    public int updateGoods(Goods goods)
    {
        goods.setUpdateTime(DateUtils.getNowDate());
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除货物
     * 
     * @param goodsIds 需要删除的货物主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsByGoodsIds(Long[] goodsIds)
    {
        return goodsMapper.deleteGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除货物信息
     * 
     * @param goodsId 货物主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.deleteGoodsByGoodsId(goodsId);
    }
}
