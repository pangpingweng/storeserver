package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.WarnMapper;
import com.platform.project.module.domain.Warn;
import com.platform.project.module.service.IWarnService;

/**
 * 报警Service业务层处理
 * 
 */
@Service
public class WarnServiceImpl implements IWarnService 
{
    @Autowired
    private WarnMapper warnMapper;

    /**
     * 查询报警
     * 
     * @param warnId 报警主键
     * @return 报警
     */
    @Override
    public Warn selectWarnByWarnId(Long warnId)
    {
        return warnMapper.selectWarnByWarnId(warnId);
    }

    /**
     * 查询报警列表
     * 
     * @param warn 报警
     * @return 报警
     */
    @Override
    public List<Warn> selectWarnList(Warn warn)
    {
        return warnMapper.selectWarnList(warn);
    }

    /**
     * 新增报警
     * 
     * @param warn 报警
     * @return 结果
     */
    @Transactional
    @Override
    public int insertWarn(Warn warn)
    {
        warn.setCreateTime(DateUtils.getNowDate());
        return warnMapper.insertWarn(warn);
    }

    /**
     * 修改报警
     * 
     * @param warn 报警
     * @return 结果
     */
    @Transactional
    @Override
    public int updateWarn(Warn warn)
    {
        return warnMapper.updateWarn(warn);
    }

    /**
     * 批量删除报警
     * 
     * @param warnIds 需要删除的报警主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWarnByWarnIds(Long[] warnIds)
    {
        return warnMapper.deleteWarnByWarnIds(warnIds);
    }

    /**
     * 删除报警信息
     * 
     * @param warnId 报警主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteWarnByWarnId(Long warnId)
    {
        return warnMapper.deleteWarnByWarnId(warnId);
    }
}
