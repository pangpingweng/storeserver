package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.StoreMapper;
import com.platform.project.module.domain.Store;
import com.platform.project.module.service.IStoreService;

/**
 * 仓库Service业务层处理
 * 
 */
@Service
public class StoreServiceImpl implements IStoreService 
{
    @Autowired
    private StoreMapper storeMapper;

    /**
     * 查询仓库
     * 
     * @param storeId 仓库主键
     * @return 仓库
     */
    @Override
    public Store selectStoreByStoreId(Long storeId)
    {
        return storeMapper.selectStoreByStoreId(storeId);
    }

    /**
     * 查询仓库列表
     * 
     * @param store 仓库
     * @return 仓库
     */
    @Override
    public List<Store> selectStoreList(Store store)
    {
        return storeMapper.selectStoreList(store);
    }

    /**
     * 新增仓库
     * 
     * @param store 仓库
     * @return 结果
     */
    @Override
    public int insertStore(Store store)
    {
        store.setCreateTime(DateUtils.getNowDate());
        return storeMapper.insertStore(store);
    }

    /**
     * 修改仓库
     * 
     * @param store 仓库
     * @return 结果
     */
    @Override
    public int updateStore(Store store)
    {
        return storeMapper.updateStore(store);
    }

    /**
     * 批量删除仓库
     * 
     * @param storeIds 需要删除的仓库主键
     * @return 结果
     */
    @Override
    public int deleteStoreByStoreIds(Long[] storeIds)
    {
        return storeMapper.deleteStoreByStoreIds(storeIds);
    }

    /**
     * 删除仓库信息
     * 
     * @param storeId 仓库主键
     * @return 结果
     */
    @Override
    public int deleteStoreByStoreId(Long storeId)
    {
        return storeMapper.deleteStoreByStoreId(storeId);
    }
}
