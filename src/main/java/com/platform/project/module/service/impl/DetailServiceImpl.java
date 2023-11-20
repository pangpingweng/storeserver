package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.DetailMapper;
import com.platform.project.module.domain.Detail;
import com.platform.project.module.service.IDetailService;

/**
 * 出入库明细Service业务层处理
 * 
 */
@Service
public class DetailServiceImpl implements IDetailService 
{
    @Autowired
    private DetailMapper detailMapper;

    /**
     * 查询出入库明细
     * 
     * @param detailId 出入库明细主键
     * @return 出入库明细
     */
    @Override
    public Detail selectDetailByDetailId(Long detailId)
    {
        return detailMapper.selectDetailByDetailId(detailId);
    }

    /**
     * 查询出入库明细列表
     * 
     * @param detail 出入库明细
     * @return 出入库明细
     */
    @Override
    public List<Detail> selectDetailList(Detail detail)
    {
        return detailMapper.selectDetailList(detail);
    }

    @Override
    public List<Detail> selectByDay(Detail detail) {
        return detailMapper.selectByDay(detail);
    }

    @Override
    public List<Detail> selectByWeek(Detail detail) {
        return detailMapper.selectByWeek(detail);
    }

    @Override
    public List<Detail> selectByMonth(Detail detail) {
        return detailMapper.selectByMonth(detail);
    }

    /**
     * 新增出入库明细
     * 
     * @param detail 出入库明细
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDetail(Detail detail)
    {
        detail.setCreateTime(DateUtils.getNowDate());
        return detailMapper.insertDetail(detail);
    }

    /**
     * 修改出入库明细
     * 
     * @param detail 出入库明细
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDetail(Detail detail)
    {
        return detailMapper.updateDetail(detail);
    }

    /**
     * 批量删除出入库明细
     * 
     * @param detailIds 需要删除的出入库明细主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDetailByDetailIds(Long[] detailIds)
    {
        return detailMapper.deleteDetailByDetailIds(detailIds);
    }

    /**
     * 删除出入库明细信息
     * 
     * @param detailId 出入库明细主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDetailByDetailId(Long detailId)
    {
        return detailMapper.deleteDetailByDetailId(detailId);
    }
}
