package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.GtypeMapper;
import com.platform.project.module.domain.Gtype;
import com.platform.project.module.service.IGtypeService;

/**
 * 货物类型Service业务层处理
 * 
 */
@Service
public class GtypeServiceImpl implements IGtypeService 
{
    @Autowired
    private GtypeMapper gtypeMapper;

    /**
     * 查询货物类型
     * 
     * @param gtypeId 货物类型主键
     * @return 货物类型
     */
    @Override
    public Gtype selectGtypeByGtypeId(Long gtypeId)
    {
        return gtypeMapper.selectGtypeByGtypeId(gtypeId);
    }

    /**
     * 查询货物类型列表
     * 
     * @param gtype 货物类型
     * @return 货物类型
     */
    @Override
    public List<Gtype> selectGtypeList(Gtype gtype)
    {
        return gtypeMapper.selectGtypeList(gtype);
    }

    /**
     * 新增货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    @Override
    public int insertGtype(Gtype gtype)
    {
        gtype.setCreateTime(DateUtils.getNowDate());
        return gtypeMapper.insertGtype(gtype);
    }

    /**
     * 修改货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    @Override
    public int updateGtype(Gtype gtype)
    {
        return gtypeMapper.updateGtype(gtype);
    }

    /**
     * 批量删除货物类型
     * 
     * @param gtypeIds 需要删除的货物类型主键
     * @return 结果
     */
    @Override
    public int deleteGtypeByGtypeIds(Long[] gtypeIds)
    {
        return gtypeMapper.deleteGtypeByGtypeIds(gtypeIds);
    }

    /**
     * 删除货物类型信息
     * 
     * @param gtypeId 货物类型主键
     * @return 结果
     */
    @Override
    public int deleteGtypeByGtypeId(Long gtypeId)
    {
        return gtypeMapper.deleteGtypeByGtypeId(gtypeId);
    }
}
