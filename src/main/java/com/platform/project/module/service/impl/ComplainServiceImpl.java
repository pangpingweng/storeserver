package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.ComplainMapper;
import com.platform.project.module.domain.Complain;
import com.platform.project.module.service.IComplainService;

/**
 * 投诉Service业务层处理
 * 
 */
@Service
public class ComplainServiceImpl implements IComplainService 
{
    @Autowired
    private ComplainMapper complainMapper;

    /**
     * 查询投诉
     * 
     * @param complainId 投诉主键
     * @return 投诉
     */
    @Override
    public Complain selectComplainByComplainId(Long complainId)
    {
        return complainMapper.selectComplainByComplainId(complainId);
    }

    /**
     * 查询投诉列表
     * 
     * @param complain 投诉
     * @return 投诉
     */
    @Override
    public List<Complain> selectComplainList(Complain complain)
    {
        return complainMapper.selectComplainList(complain);
    }

    /**
     * 新增投诉
     * 
     * @param complain 投诉
     * @return 结果
     */
    @Transactional
    @Override
    public int insertComplain(Complain complain)
    {
        complain.setCreateTime(DateUtils.getNowDate());
        return complainMapper.insertComplain(complain);
    }

    /**
     * 修改投诉
     * 
     * @param complain 投诉
     * @return 结果
     */
    @Transactional
    @Override
    public int updateComplain(Complain complain)
    {
        return complainMapper.updateComplain(complain);
    }

    /**
     * 批量删除投诉
     * 
     * @param complainIds 需要删除的投诉主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteComplainByComplainIds(Long[] complainIds)
    {
        return complainMapper.deleteComplainByComplainIds(complainIds);
    }

    /**
     * 删除投诉信息
     * 
     * @param complainId 投诉主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteComplainByComplainId(Long complainId)
    {
        return complainMapper.deleteComplainByComplainId(complainId);
    }
}
