package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.AreaMapper;
import com.platform.project.module.domain.Area;
import com.platform.project.module.service.IAreaService;

/**
 * 分区Service业务层处理
 * 
 */
@Service
public class AreaServiceImpl implements IAreaService 
{
    @Autowired
    private AreaMapper areaMapper;

    /**
     * 查询分区
     * 
     * @param areaId 分区主键
     * @return 分区
     */
    @Override
    public Area selectAreaByAreaId(Long areaId)
    {
        return areaMapper.selectAreaByAreaId(areaId);
    }

    /**
     * 查询分区列表
     * 
     * @param area 分区
     * @return 分区
     */
    @Override
    public List<Area> selectAreaList(Area area)
    {
        return areaMapper.selectAreaList(area);
    }

    /**
     * 新增分区
     * 
     * @param area 分区
     * @return 结果
     */
    @Transactional
    @Override
    public int insertArea(Area area)
    {
        area.setCreateTime(DateUtils.getNowDate());
        return areaMapper.insertArea(area);
    }

    /**
     * 修改分区
     * 
     * @param area 分区
     * @return 结果
     */
    @Transactional
    @Override
    public int updateArea(Area area)
    {
        return areaMapper.updateArea(area);
    }

    /**
     * 批量删除分区
     * 
     * @param areaIds 需要删除的分区主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAreaByAreaIds(Long[] areaIds)
    {
        return areaMapper.deleteAreaByAreaIds(areaIds);
    }

    /**
     * 删除分区信息
     * 
     * @param areaId 分区主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAreaByAreaId(Long areaId)
    {
        return areaMapper.deleteAreaByAreaId(areaId);
    }
}
