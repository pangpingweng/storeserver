package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Store;

/**
 * 仓库Mapper接口
 * 
 */
public interface StoreMapper 
{
    /**
     * 查询仓库
     * 
     * @param storeId 仓库主键
     * @return 仓库
     */
    public Store selectStoreByStoreId(Long storeId);

    /**
     * 查询仓库列表
     * 
     * @param store 仓库
     * @return 仓库集合
     */
    public List<Store> selectStoreList(Store store);

    /**
     * 新增仓库
     * 
     * @param store 仓库
     * @return 结果
     */
    public int insertStore(Store store);

    /**
     * 修改仓库
     * 
     * @param store 仓库
     * @return 结果
     */
    public int updateStore(Store store);

    /**
     * 删除仓库
     * 
     * @param storeId 仓库主键
     * @return 结果
     */
    public int deleteStoreByStoreId(Long storeId);

    /**
     * 批量删除仓库
     * 
     * @param storeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoreByStoreIds(Long[] storeIds);
}
