package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.StockMapper;
import com.platform.project.module.domain.Stock;
import com.platform.project.module.service.IStockService;

/**
 * 出入库Service业务层处理
 * 
 */
@Service
public class StockServiceImpl implements IStockService 
{
    @Autowired
    private StockMapper stockMapper;

    /**
     * 查询出入库
     * 
     * @param stockId 出入库主键
     * @return 出入库
     */
    @Override
    public Stock selectStockByStockId(Long stockId)
    {
        return stockMapper.selectStockByStockId(stockId);
    }

    /**
     * 查询出入库列表
     * 
     * @param stock 出入库
     * @return 出入库
     */
    @Override
    public List<Stock> selectStockList(Stock stock)
    {
        return stockMapper.selectStockList(stock);
    }

    /**
     * 新增出入库
     * 
     * @param stock 出入库
     * @return 结果
     */
    @Transactional
    @Override
    public int insertStock(Stock stock)
    {
        stock.setCreateTime(DateUtils.getNowDate());
        return stockMapper.insertStock(stock);
    }

    /**
     * 修改出入库
     * 
     * @param stock 出入库
     * @return 结果
     */
    @Transactional
    @Override
    public int updateStock(Stock stock)
    {
        stock.setUpdateTime(DateUtils.getNowDate());
        return stockMapper.updateStock(stock);
    }

    /**
     * 批量删除出入库
     * 
     * @param stockIds 需要删除的出入库主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteStockByStockIds(Long[] stockIds)
    {
        return stockMapper.deleteStockByStockIds(stockIds);
    }

    /**
     * 删除出入库信息
     * 
     * @param stockId 出入库主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteStockByStockId(Long stockId)
    {
        return stockMapper.deleteStockByStockId(stockId);
    }
}
