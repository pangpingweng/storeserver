package com.platform.project.module.service;

import java.util.List;
import com.platform.project.module.domain.Gtype;

/**
 * 货物类型Service接口
 * 
 */
public interface IGtypeService 
{
    /**
     * 查询货物类型
     * 
     * @param gtypeId 货物类型主键
     * @return 货物类型
     */
    public Gtype selectGtypeByGtypeId(Long gtypeId);

    /**
     * 查询货物类型列表
     * 
     * @param gtype 货物类型
     * @return 货物类型集合
     */
    public List<Gtype> selectGtypeList(Gtype gtype);

    /**
     * 新增货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    public int insertGtype(Gtype gtype);

    /**
     * 修改货物类型
     * 
     * @param gtype 货物类型
     * @return 结果
     */
    public int updateGtype(Gtype gtype);

    /**
     * 批量删除货物类型
     * 
     * @param gtypeIds 需要删除的货物类型主键集合
     * @return 结果
     */
    public int deleteGtypeByGtypeIds(Long[] gtypeIds);

    /**
     * 删除货物类型信息
     * 
     * @param gtypeId 货物类型主键
     * @return 结果
     */
    public int deleteGtypeByGtypeId(Long gtypeId);
}
