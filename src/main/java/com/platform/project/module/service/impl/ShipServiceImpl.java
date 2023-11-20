package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.ShipMapper;
import com.platform.project.module.domain.Ship;
import com.platform.project.module.service.IShipService;

/**
 * 运输Service业务层处理
 * 
 */
@Service
public class ShipServiceImpl implements IShipService 
{
    @Autowired
    private ShipMapper shipMapper;

    /**
     * 查询运输
     * 
     * @param shipId 运输主键
     * @return 运输
     */
    @Override
    public Ship selectShipByShipId(Long shipId)
    {
        return shipMapper.selectShipByShipId(shipId);
    }

    /**
     * 查询运输列表
     * 
     * @param ship 运输
     * @return 运输
     */
    @Override
    public List<Ship> selectShipList(Ship ship)
    {
        return shipMapper.selectShipList(ship);
    }
    @Override
    public List<Ship> selectWuliuList(Ship ship)
    {
        return shipMapper.selectWuliuList(ship);
    }
    /**
     * 新增运输
     * 
     * @param ship 运输
     * @return 结果
     */
    @Transactional
    @Override
    public int insertShip(Ship ship)
    {
        ship.setCreateTime(DateUtils.getNowDate());
        return shipMapper.insertShip(ship);
    }

    /**
     * 修改运输
     * 
     * @param ship 运输
     * @return 结果
     */
    @Transactional
    @Override
    public int updateShip(Ship ship)
    {
        return shipMapper.updateShip(ship);
    }

    /**
     * 批量删除运输
     * 
     * @param shipIds 需要删除的运输主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteShipByShipIds(Long[] shipIds)
    {
        return shipMapper.deleteShipByShipIds(shipIds);
    }

    /**
     * 删除运输信息
     * 
     * @param shipId 运输主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteShipByShipId(Long shipId)
    {
        return shipMapper.deleteShipByShipId(shipId);
    }
}
