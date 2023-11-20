package com.platform.project.module.service;

import java.util.List;
import com.platform.project.module.domain.Complain;

/**
 * 投诉Service接口
 * 
 */
public interface IComplainService 
{
    /**
     * 查询投诉
     * 
     * @param complainId 投诉主键
     * @return 投诉
     */
    public Complain selectComplainByComplainId(Long complainId);

    /**
     * 查询投诉列表
     * 
     * @param complain 投诉
     * @return 投诉集合
     */
    public List<Complain> selectComplainList(Complain complain);

    /**
     * 新增投诉
     * 
     * @param complain 投诉
     * @return 结果
     */
    public int insertComplain(Complain complain);

    /**
     * 修改投诉
     * 
     * @param complain 投诉
     * @return 结果
     */
    public int updateComplain(Complain complain);

    /**
     * 批量删除投诉
     * 
     * @param complainIds 需要删除的投诉主键集合
     * @return 结果
     */
    public int deleteComplainByComplainIds(Long[] complainIds);

    /**
     * 删除投诉信息
     * 
     * @param complainId 投诉主键
     * @return 结果
     */
    public int deleteComplainByComplainId(Long complainId);
}
