package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Area;

/**
 * 分区Mapper接口
 * 
 */
public interface AreaMapper 
{
    /**
     * 查询分区
     * 
     * @param areaId 分区主键
     * @return 分区
     */
    public Area selectAreaByAreaId(Long areaId);

    /**
     * 查询分区列表
     * 
     * @param area 分区
     * @return 分区集合
     */
    public List<Area> selectAreaList(Area area);

    /**
     * 新增分区
     * 
     * @param area 分区
     * @return 结果
     */
    public int insertArea(Area area);

    /**
     * 修改分区
     * 
     * @param area 分区
     * @return 结果
     */
    public int updateArea(Area area);

    /**
     * 删除分区
     * 
     * @param areaId 分区主键
     * @return 结果
     */
    public int deleteAreaByAreaId(Long areaId);

    /**
     * 批量删除分区
     * 
     * @param areaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAreaByAreaIds(Long[] areaIds);
}
