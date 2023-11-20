package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Stock;

/**
 * 出入库Mapper接口
 * 
 */
public interface StockMapper 
{
    /**
     * 查询出入库
     * 
     * @param stockId 出入库主键
     * @return 出入库
     */
    public Stock selectStockByStockId(Long stockId);

    /**
     * 查询出入库列表
     * 
     * @param stock 出入库
     * @return 出入库集合
     */
    public List<Stock> selectStockList(Stock stock);

    /**
     * 新增出入库
     * 
     * @param stock 出入库
     * @return 结果
     */
    public int insertStock(Stock stock);

    /**
     * 修改出入库
     * 
     * @param stock 出入库
     * @return 结果
     */
    public int updateStock(Stock stock);

    /**
     * 删除出入库
     * 
     * @param stockId 出入库主键
     * @return 结果
     */
    public int deleteStockByStockId(Long stockId);

    /**
     * 批量删除出入库
     * 
     * @param stockIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStockByStockIds(Long[] stockIds);
}
