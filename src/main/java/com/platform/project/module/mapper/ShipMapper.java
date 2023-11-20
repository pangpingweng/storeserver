package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Ship;

/**
 * 运输Mapper接口
 * 
 */
public interface ShipMapper 
{
    /**
     * 查询运输
     * 
     * @param shipId 运输主键
     * @return 运输
     */
    public Ship selectShipByShipId(Long shipId);

    /**
     * 查询运输列表
     * 
     * @param ship 运输
     * @return 运输集合
     */
    public List<Ship> selectShipList(Ship ship);
    public List<Ship> selectWuliuList(Ship ship);

    /**
     * 新增运输
     * 
     * @param ship 运输
     * @return 结果
     */
    public int insertShip(Ship ship);

    /**
     * 修改运输
     * 
     * @param ship 运输
     * @return 结果
     */
    public int updateShip(Ship ship);

    /**
     * 删除运输
     * 
     * @param shipId 运输主键
     * @return 结果
     */
    public int deleteShipByShipId(Long shipId);

    /**
     * 批量删除运输
     * 
     * @param shipIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShipByShipIds(Long[] shipIds);
}
